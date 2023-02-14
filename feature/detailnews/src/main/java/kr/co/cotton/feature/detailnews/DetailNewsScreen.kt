package kr.co.cotton.feature.detailnews

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import kr.co.cotton.core.designsystem.component.common.CottonScaffold
import kr.co.cotton.core.designsystem.component.common.CottonTopBar

@Composable
internal fun DetailNewsRoute(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: DetailNewsViewModel = hiltViewModel()
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
