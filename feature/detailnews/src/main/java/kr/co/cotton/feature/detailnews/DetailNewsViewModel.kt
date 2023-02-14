package kr.co.cotton.feature.detailnews

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import kr.co.cotton.core.common.Result
import kr.co.cotton.core.common.asResult
import kr.co.cotton.core.common.base.BaseViewModel
import kr.co.cotton.core.data.detailnews.repository.DetailNewsRepository

@HiltViewModel
class DetailNewsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val detailNewsRepository: DetailNewsRepository,
) : BaseViewModel() {

    private val nId: String = checkNotNull(savedStateHandle["nId"])
    private val title: String = checkNotNull(savedStateHandle["title"])

    private val _detailNewsUiState = MutableStateFlow<DetailNewsUiState>(DetailNewsUiState.Loading)
    val detailNewsUiState: StateFlow<DetailNewsUiState> = _detailNewsUiState.asStateFlow()

    init {
        getDetailNews(nId, title)
    }

    private fun getDetailNews(nId: String, title: String) = viewModelScope.launch {
        detailNewsRepository.getDetailNews(nId, title).asResult()
            .map { result ->
                _detailNewsUiState.value = when (result) {
                    is Result.Success -> DetailNewsUiState.Success(result.data)
                    is Result.Loading -> DetailNewsUiState.Loading
                    is Result.Error -> DetailNewsUiState.Loading
                }
            }.collect()
    }
}

sealed interface DetailNewsUiState {
    data class Success(val detailNewsResult: String) : DetailNewsUiState
    object Loading : DetailNewsUiState
    object Error : DetailNewsUiState
}
