package kr.co.cotton.common.base

import androidx.activity.ComponentActivity

abstract class BaseActivity<VM : BaseViewModel> : ComponentActivity() {

    abstract val viewModel: VM
}