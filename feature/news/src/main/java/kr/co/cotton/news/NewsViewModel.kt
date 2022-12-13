package kr.co.cotton.news

import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
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

    val newsListFlow = newsRepository.getValEsportsNews().cachedIn(viewModelScope)

    init {
        getNewsMaxIndex()
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
}
