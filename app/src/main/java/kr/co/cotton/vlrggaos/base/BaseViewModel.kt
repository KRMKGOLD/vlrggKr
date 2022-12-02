package kr.co.cotton.vlrggaos.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

open class BaseViewModel : ViewModel() {

    protected val _isLoading = MutableStateFlow(false)

}