package kr.co.cotton.feature.search

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
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

    private val _searchListUiState = MutableStateFlow<SearchListUiState>(
        SearchListUiState.Success(emptyList())
    )
    val searchListUiState: StateFlow<SearchListUiState> = _searchListUiState.asStateFlow()

    fun getSearchData(searchQuery: String) = viewModelScope.launch {
        searchRepository.getAllSearchData(searchQuery).asResult()
            .map { result ->
                _searchListUiState.value = when (result) {
                    is Result.Success -> SearchListUiState.Success(result.data)
                    is Result.Loading -> SearchListUiState.Loading
                    is Result.Error -> SearchListUiState.Error
                }
            }.collect()
    }
}

sealed interface SearchListUiState {
    data class Success(val news: List<SearchResult>) : SearchListUiState
    object Loading : SearchListUiState
    object Error : SearchListUiState
}

