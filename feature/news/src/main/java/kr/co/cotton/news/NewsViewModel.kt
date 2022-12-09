package kr.co.cotton.news

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kr.co.cotton.common.Result
import kr.co.cotton.common.asResult
import kr.co.cotton.common.base.BaseViewModel
import kr.co.cotton.data.sportsnews.ValEsportsNews
import kr.co.cotton.data.sportsnews.repository.ValEsportsNewsRepository
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val newsRepository: ValEsportsNewsRepository
) : BaseViewModel() {

    private val _maxNewsIndex = MutableStateFlow(0)

    private val currentIndex = MutableStateFlow(1)

    private val _newsUiState = MutableStateFlow<NewsUiState>(NewsUiState.Loading)
    val newsUiState: StateFlow<NewsUiState> = _newsUiState.asStateFlow()

    init {
        getNewsMaxIndex()
        getNewsUiState(currentIndex.value)
    }

    private fun getNewsMaxIndex() = viewModelScope.launch {
        newsRepository.getNewsMaxIndex().asResult()
            .map { maxIdxResult ->
                _maxNewsIndex.value = when (maxIdxResult) {
                    is Result.Success -> maxIdxResult.data
                    is Result.Loading -> 0
                    is Result.Error -> -1
                }
            }.collect()
    }

    private fun getNewsUiState(index: Int) = viewModelScope.launch {
        newsRepository.getValEsportsNews(index).asResult()
            .map { newsResult ->
                _newsUiState.value = when (newsResult) {
                    is Result.Success -> NewsUiState.Success(newsResult.data)
                    is Result.Loading -> NewsUiState.Loading
                    is Result.Error -> NewsUiState.Error
                }
            }.collect()
    }

    fun onClickNewsItem(news: ValEsportsNews) {
        // TODO : Click News
    }

    fun onClickIndexBtn(index: Int) {
        currentIndex.tryEmit(currentIndex.value + 1)
//        getNewsUiState(currentIndex.value)
        getNewsUiState(index)
    }
}

sealed interface NewsUiState {
    data class Success(val news: List<ValEsportsNews>) : NewsUiState
    object Error : NewsUiState
    object Loading : NewsUiState
}
