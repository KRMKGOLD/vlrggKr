package kr.co.cotton.feature.detailnews

import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import kr.co.cotton.core.designsystem.component.common.CottonErrorView
import kr.co.cotton.core.designsystem.component.common.CottonLoadingView
import kr.co.cotton.core.designsystem.component.common.CottonScaffold
import kr.co.cotton.core.designsystem.component.common.CottonTopBar

@Composable
internal fun DetailNewsRoute(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: DetailNewsViewModel = hiltViewModel(),
) {

    val detailNewsUiState by viewModel.detailNewsUiState.collectAsState()

    DetailNewsScreen(
        modifier = modifier,
        navController = navController,
        detailNewsUiState = detailNewsUiState,
    )
}

@Composable
fun DetailNewsScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    detailNewsUiState: DetailNewsUiState,
) {
    CottonScaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            CottonTopBar(onClickBackBtn = { navController.popBackStack() })
        },
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            when (detailNewsUiState) {
                is DetailNewsUiState.Success -> {
                    val context = LocalContext.current
                    AndroidView(
                        factory = {
                            WebView(context).apply {
                                this.webViewClient = WebViewClient()
                                this.loadData(
                                    detailNewsUiState.detailNewsResult,
                                    "text/html; charset=utf-8",
                                    "utf-8",
                                )
                            }
                        },
                    )
                }
                DetailNewsUiState.Loading -> {
                    CottonLoadingView(
                        modifier = Modifier.fillMaxSize(),
                    )
                }
                DetailNewsUiState.Error -> {
                    CottonErrorView(
                        modifier = Modifier.fillMaxSize(),
                        errorTitle = "Error!",
                        errorMessage = "Failed to get data. Please try again later.",
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DetailNewsScreenPreview() {
    DetailNewsScreen(
        navController = rememberNavController(),
        detailNewsUiState = DetailNewsUiState.Loading,
    )
}
