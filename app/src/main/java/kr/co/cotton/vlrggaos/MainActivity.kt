package kr.co.cotton.vlrggaos

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import kr.co.cotton.common.base.BaseActivity
import kr.co.cotton.vlrggaos.ui.HomeScreen
import kr.co.cotton.vlrggaos.ui.theme.CottonTheme

@AndroidEntryPoint
class MainActivity : BaseActivity<MainViewModel>() {

    override val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CottonTheme {
                HomeScreen()
            }
        }
    }

    override fun observeEventFlow() = lifecycleScope.launch {
        super.observeEventFlow()

        viewModel.onClickBackBtn.collect {
            onBackPressedDispatcher.onBackPressed()
        }
    }
}
