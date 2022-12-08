package kr.co.cotton.common.base

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch

abstract class BaseActivity<VM : BaseViewModel> : ComponentActivity() {

    abstract val viewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        showToast()
    }

    private fun showToast() {
        lifecycleScope.launch {
            viewModel.showToast.collect {
                Toast.makeText(this@BaseActivity, it, Toast.LENGTH_SHORT).show()
            }
        }
    }
}