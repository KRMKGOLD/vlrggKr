package kr.co.cotton.news

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kr.co.cotton.common.Result
import kr.co.cotton.common.asResult
import kr.co.cotton.common.base.BaseViewModel
import kr.co.cotton.data.sportsnews.ValEsportsNews
import kr.co.cotton.data.sportsnews.repository.ValEsportsNewsRepository
import javax.inject.Inject

@OptIn(ExperimentalCoroutinesApi::class)
@HiltViewModel
class NewsViewModel @Inject constructor(
    private val newsRepository: ValEsportsNewsRepository
) : BaseViewModel() {

    val maxNewsIndex: StateFlow<Int> = newsRepository.maxNewsIndexStream()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.Eagerly,
            initialValue = 0
        )

    val maxIndex = MutableStateFlow(0)

    private val currentIndex = MutableStateFlow(1)

    val newsUiState: StateFlow<NewsUiState> =
        newsRepository.getNewsListStream(currentIndex.value)
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5000),
                initialValue = NewsUiState.Loading
            )

    init {
        getNewsMaxIndex()
    }

    private fun getNewsUiState(index: Int) = viewModelScope.launch {
        currentIndex.value = index
    }

    private fun getNewsMaxIndex() = viewModelScope.launch {
        maxNewsIndex.collect {
            if (it == -1) {
                showToast("Failed Get Max Index")
            }
        }
    }

    /**
     * TODO : Local 부분에 Cache 로직을 추가
     * https://github.com/android/architecture-samples/blob/main/app/src/main/java/com/example/android/architecture/blueprints/todoapp/data/source/DefaultTasksRepository.kt
     */
    fun onClickNewsItem(news: ValEsportsNews) {
        // TODO : Click News
    }

    fun onClickIndexBtn() {
        getNewsUiState(currentIndex.value + 1)
    }
}

private fun ValEsportsNewsRepository.maxNewsIndexStream(): Flow<Int> {
    return this.getNewsMaxIndex().asResult()
        .map { maxIdxResult ->
            when (maxIdxResult) {
                is Result.Success -> {
                    maxIdxResult.data
                }
                is Result.Loading -> 0
                is Result.Error -> -1
            }
        }
}

private fun ValEsportsNewsRepository.getNewsListStream(index: Int): Flow<NewsUiState> {
    return this.getValEsportsNews(index).asResult()
        .map { newsResult ->
            when (newsResult) {
                is Result.Success -> {
                    NewsUiState.Success(newsResult.data)
                }
                is Result.Loading -> NewsUiState.Loading
                is Result.Error -> {
                    NewsUiState.Error
                }
            }
        }
}

sealed interface NewsUiState {
    data class Success(val news: List<ValEsportsNews>) : NewsUiState
    object Error : NewsUiState
    object Loading : NewsUiState
}
