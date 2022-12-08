package kr.co.cotton.common.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow

open class BaseViewModel : ViewModel() {

    private val _showToast = MutableSharedFlow<String>()
    val showToast: SharedFlow<String> = _showToast

    fun showToast(toast: String) {
        _showToast.tryEmit(toast)
    }
}