package kr.co.cotton.news

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kr.co.cotton.data.sportsnews.ValEsportsNews
import kr.co.cotton.data.sportsnews.repository.ValEsportsNewsRepository
import kr.co.cotton.vlrggaos.Result
import kr.co.cotton.vlrggaos.asResult
import kr.co.cotton.vlrggaos.base.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val newsRepository: ValEsportsNewsRepository
) : BaseViewModel() {

    private val _newsUiState = MutableStateFlow<NewsUiState>(NewsUiState.Loading)
    val newsUiState: StateFlow<NewsUiState> = _newsUiState

    private val _newsMaxIndex = MutableLiveData(0)
    val newsMaxIndex: LiveData<Int> = _newsMaxIndex

    private val _newsList = MutableLiveData<List<ValEsportsNews>>(emptyList())
    val newsList: LiveData<List<ValEsportsNews>> = _newsList

    init {
        getNewsMaxIndex()
    }

    private fun getNewsMaxIndex() = viewModelScope.launch {
        _isLoading.value = true

        newsRepository.getNewsMaxIndex().asResult()
            .map { maxIdxResult ->
                when (maxIdxResult) {
                    is Result.Success -> {
                        _newsMaxIndex.value = maxIdxResult.data
                        getValEsportsNews(1)
                    }
                    is Result.Error -> {
                        // TODO : ERROR DIALOG
                    }
                    is Result.Loading -> _newsUiState.value = NewsUiState.Error
                }
            }
    }

    /**
     * TODO : Local 부분에 Cache 로직을 추가
     * https://github.com/android/architecture-samples/blob/main/app/src/main/java/com/example/android/architecture/blueprints/todoapp/data/source/DefaultTasksRepository.kt
     */
    private fun getValEsportsNews(index: Int) = viewModelScope.launch {
        if (index > (_newsMaxIndex.value ?: 0)) {
            // TODO : IndexOutOfException
        } else {
            newsRepository.getValEsportsNews(index).asResult()
                .map { newsResult ->
                    when (newsResult) {
                        is Result.Success -> NewsUiState.Success(newsResult.data)
                        is Result.Error -> NewsUiState.Error
                        is Result.Loading -> NewsUiState.Loading
                    }
                }
        }
    }

    fun onClickNewsItem(news: ValEsportsNews) {
        // TODO : Click News
    }
}

sealed interface NewsUiState {
    data class Success(val news: List<ValEsportsNews>) : NewsUiState
    object Error : NewsUiState
    object Loading : NewsUiState
}
