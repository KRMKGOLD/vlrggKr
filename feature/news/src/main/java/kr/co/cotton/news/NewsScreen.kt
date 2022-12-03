package kr.co.cotton.news

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
        onClickBack = onClickBack,
        onClickItem = { viewModel.onClickNewsItem(it) }
    )
}

@Composable
fun NewsScreen(
    modifier: Modifier = Modifier,
    newsUiState: NewsUiState,
    onClickBack: () -> Unit,
    onClickItem: (ValEsportsNews) -> Unit
) {
    val state = rememberLazyListState()

    LazyColumn(
        modifier = modifier,
        state = state,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        when (newsUiState) {
            is NewsUiState.Success -> {
                items(newsUiState.news) { news ->
                    NewsCard(news = news)
                }
            }
            else -> {
                // TODO : Make VlrGGLoadingView
            }
//            is NewsUiState.Error -> TODO()
//            is NewsUiState.Loading -> {
//                // TODO : Make VlrGGLoadingView
//            }
        }
    }
}

@Composable
fun NewsCard(
    modifier: Modifier = Modifier,
    news: ValEsportsNews,
    onClickCard: () -> Unit = {}
) {
    Card {
        Column(
            modifier = modifier
                .padding(16.dp)
                .clickable { onClickCard() }
        ) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = news.title.orEmpty(),
                style = MaterialTheme.typography.h6,
                color = Color.Black,
            )
            Text(
                modifier = Modifier
                    .padding(top = 4.dp)
                    .fillMaxWidth(),
                text = news.description.orEmpty(),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.subtitle2,
                color = Color.DarkGray
            )
            Row(
                modifier = Modifier
                    .padding(top = 4.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    modifier = Modifier,
                    text = news.date.orEmpty(),
                    color = Color.Gray,
                    style = MaterialTheme.typography.caption
                )
                Text(
                    modifier = Modifier.padding(start = 4.dp),
                    text = news.writer.orEmpty(),
                    color = Color.Gray,
                    style = MaterialTheme.typography.caption
                )
            }
        }
    }
}

@Preview
@Composable
fun NewsCardPreview() {
    NewsCard(
        news = ValEsportsNews(
            title = "Gen.G reveal all-Korean roster",
            description = "VLR.gg's roster tracker keeps up to date on roster moves in the Pacific region in view of the upcome asdfasdfasdfasdfasdfasdfasdf",
            flagISO = "KR",
            date = "October 22, 2022",
            writer = "Dr.Sun Cotton"
        )
    )
}