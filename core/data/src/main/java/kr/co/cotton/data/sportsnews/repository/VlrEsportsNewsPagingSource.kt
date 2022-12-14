package kr.co.cotton.data.sportsnews.repository

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kr.co.cotton.data.model.ValEsportsNews
import kr.co.cotton.data.sportsnews.datasource.ValEsportsNewsDataSource

class VlrEsportsNewsPagingSource(
    private val remoteValEsportsNewsDataSource: ValEsportsNewsDataSource,
    private val localValEsportsNewsDataSource: ValEsportsNewsDataSource,
) : PagingSource<Int, ValEsportsNews>() {

    override fun getRefreshKey(state: PagingState<Int, ValEsportsNews>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ValEsportsNews> {
        return try {
            val page = params.key ?: 1

            withContext(Dispatchers.IO) {
                val cached = localValEsportsNewsDataSource.getValEsportsNews(page)
                val data = cached.ifEmpty {
                    val remote = remoteValEsportsNewsDataSource.getValEsportsNews(page)
                    localValEsportsNewsDataSource.updateValEsportsNews(page, remote)
                    remote
                }

                val nextKey = if (data.any { news -> news.href == "//" }) null else page + 1

                Log.d("data", data.toString())

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