package kr.co.cotton.core.data.search.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kr.co.cotton.core.data.search.datasource.SearchDataSource
import kr.co.cotton.core.data.search.model.SearchResult
import javax.inject.Inject
import javax.inject.Named

class DefaultSearchRepository @Inject constructor(
    @Named("REMOTE") private val remoteSearchDataSource: SearchDataSource,
) : SearchRepository {

    override fun getAllSearchData(query: String): Flow<List<SearchResult>> = flow {
        emit(remoteSearchDataSource.getAllSearchData(query))
    }.flowOn(Dispatchers.IO)

    override fun getSearchDataWithCategory(
        category: SearchResult,
        query: String
    ): Flow<List<SearchResult>> = flow {
        emit(remoteSearchDataSource.getSearchDataWithCategory(category, query))
    }.flowOn(Dispatchers.IO)
}