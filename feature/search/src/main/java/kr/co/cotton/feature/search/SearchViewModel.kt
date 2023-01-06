package kr.co.cotton.feature.search

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kr.co.cotton.core.common.Result
import kr.co.cotton.core.common.asResult
import kr.co.cotton.core.common.base.BaseViewModel
import kr.co.cotton.core.data.search.model.SearchResult
import kr.co.cotton.core.data.search.repository.SearchRepository
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val searchRepository: SearchRepository
) : BaseViewModel() {

    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery.asStateFlow()

    private val _searchData = MutableStateFlow<List<SearchResult>>(emptyList())
    val searchData: StateFlow<List<SearchResult>> = _searchData.asStateFlow()

    init {

    }

    private suspend fun getSearchData() {
        searchRepository.getAllSearchData(searchQuery.value).asResult()
            .map { result ->
                _searchData.value = when (result) {
                    is Result.Success -> result.data
                    is Result.Loading -> emptyList()
                    is Result.Error -> emptyList()
                }
            }.collect()
    }
}