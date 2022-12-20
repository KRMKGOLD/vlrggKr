package kr.co.cotton.vlrggaos

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import kr.co.cotton.common.base.BaseActivity
import kr.co.cotton.vlrggaos.ui.MainScreen
import kr.co.cotton.designsystem.component.theme.CottonTheme

@AndroidEntryPoint
class MainActivity : BaseActivity<MainViewModel>() {

    override val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CottonTheme {
                MainScreen()
            }
        }
    }
}
