package kr.co.cotton.core.data.search.datasource

import kr.co.cotton.core.data.search.model.SearchResult
import javax.inject.Inject

class LocalSearchDataSource @Inject constructor() : SearchDataSource {

    override fun getAllSearchData(query: String) {
        throw NotImplementedError()
    }

    override fun <T : SearchResult> getSearchDataWithCategory(category: T, query: String) {
        throw NotImplementedError()
    }
}