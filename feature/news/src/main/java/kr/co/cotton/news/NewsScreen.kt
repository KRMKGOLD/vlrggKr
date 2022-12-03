package kr.co.cotton.news

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kr.co.cotton.data.sportsnews.ValEsportsNews

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
    val scrollableState = rememberLazyListState()

    LazyColumn(
        modifier = Modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        state = scrollableState
    ) {
    }
}

@Composable
fun NewsCard(
    modifier: Modifier = Modifier,
    uiState: ValEsportsNews,
    onClickCard: () -> Unit = {}
) {
    Card(
        modifier = modifier.padding(16.dp)
    ) {
        Text(
            modifier = Modifier,
            text = uiState.title.orEmpty()
        )
        Text(
            modifier = Modifier,
            text = uiState.description.orEmpty(),
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                modifier = Modifier,
                text = uiState.date.orEmpty(),
            )
            Text(
                modifier = Modifier,
                text = uiState.writer.orEmpty(),
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NewsCardPreview() {
    NewsCard(
        modifier = Modifier.padding(16.dp),
        uiState = ValEsportsNews(
            title = "title",
            description = "description",
            flagISO = "test",
            date = "date",
            writer = "writer"
        )
    )
}