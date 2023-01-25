package kr.co.cotton.core.data.sportsnews.repository

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kr.co.cotton.core.data.sportsnews.model.News
import kr.co.cotton.core.data.sportsnews.datasource.NewsDataSource

class NewsPagingSource(
    private val remoteNewsDataSource: NewsDataSource,
    private val localNewsDataSource: NewsDataSource,
) : PagingSource<Int, News>() {

    override fun getRefreshKey(state: PagingState<Int, News>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, News> {
        return try {
            val page = params.key ?: 1

            withContext(Dispatchers.IO) {
                val cached = localNewsDataSource.getValEsportsNews(page)
                val data = cached.ifEmpty {
                    val remote = remoteNewsDataSource.getValEsportsNews(page)
                    localNewsDataSource.updateValEsportsNews(page, remote)
                    remote
                }

                val nextKey = if (data.any { news -> news.href == "//" }) null else page + 1

                LoadResult.Page(
                    data = data,
                    prevKey = null,
                    nextKey = nextKey
                )
            }
        } catch (e: Exception) {
            Log.d("error", e.toString())
            return LoadResult.Error(e)
        }
    }
}