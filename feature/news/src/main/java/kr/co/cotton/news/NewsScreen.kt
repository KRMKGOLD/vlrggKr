package kr.co.cotton.news

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@OptIn(ExperimentalLifecycleComposeApi::class)
@Composable
internal fun NewsRoute(
    modifier: Modifier = Modifier,
    onClickBack: () -> Unit,
    viewModel: NewsViewModel = hiltViewModel()
) {
    val newsUiState: NewsUiState by viewModel.newsUiState.collectAsStateWithLifecycle()

    NewsScreen(
        modifier = modifier,
        newsUiState = newsUiState,
        onClickBack = onClickBack
    )
}

@Composable
fun NewsScreen(
    modifier: Modifier = Modifier,
    newsUiState: NewsUiState,
    onClickBack: () -> Unit
) {

}