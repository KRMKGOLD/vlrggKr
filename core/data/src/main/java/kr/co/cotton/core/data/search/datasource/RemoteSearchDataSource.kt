package kr.co.cotton.core.data.search.datasource

import kr.co.cotton.core.data.search.model.SearchResult
import javax.inject.Inject

class RemoteSearchDataSource @Inject constructor() : SearchDataSource {

    override fun getAllSearchData(): Int {
        TODO("Not yet implemented")
    }

    override fun <T : SearchResult> getSearchDataWithCategory(category: T) {
        TODO("Not yet implemented")
    }
}