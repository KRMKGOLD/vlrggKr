package kr.co.cotton.feature.search

import androidx.lifecycle.SavedStateHandle
import dagger.hilt.android.lifecycle.HiltViewModel
import kr.co.cotton.core.common.base.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) : BaseViewModel() {

    private val searchValue: String = checkNotNull(savedStateHandle["searchValue"])

    init {
        // TODO : SearchValue 이용한 Search Data Parse 개발
    }
}