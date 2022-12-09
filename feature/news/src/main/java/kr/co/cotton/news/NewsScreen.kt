package kr.co.cotton.news

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.murgupluoglu.flagkit.FlagKit
import dagger.hilt.android.internal.managers.FragmentComponentManager.findActivity
import kr.co.cotton.data.sportsnews.ValEsportsNews
import kr.co.cotton.designsystem.component.CottonLoadingView

@Composable
internal fun NewsRoute(
    modifier: Modifier = Modifier,
    viewModel: NewsViewModel = hiltViewModel()
) {
    val newsUiState: NewsUiState by viewModel.newsUiState.collectAsState()

    NewsScreen(
        modifier = modifier,
        newsUiState = newsUiState,
        onClickItem = { viewModel.onClickNewsItem(it) },
        onClickIndexBtn = { viewModel.onClickIndexBtn(it) }
    )
}

@Composable
fun NewsScreen(
    modifier: Modifier = Modifier,
    newsUiState: NewsUiState,
    onClickItem: (ValEsportsNews) -> Unit,
    onClickIndexBtn: (Int) -> Unit
) {
    val state = rememberLazyListState()

    when (newsUiState) {
        is NewsUiState.Success -> {
            LazyColumn(
                modifier = modifier,
                state = state,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                items(newsUiState.news) { news ->
                    NewsCard(
                        modifier = Modifier.padding(top = 16.dp, start = 16.dp, end = 16.dp),
                        news = news,
                        onClickCard = onClickItem
                    )
                }
                item {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Button(
                            content = {
                                Text(text = "1")
                            },
                            onClick = { onClickIndexBtn(1) }
                        )
                        Button(
                            content = {
                                Text(text = "2")
                            },
                            onClick = { onClickIndexBtn(2) }
                        )
                        Button(
                            content = {
                                Text(text = "3")
                            },
                            onClick = { onClickIndexBtn(3) }
                        )
                        Button(
                            content = {
                                Text(text = "4")
                            },
                            onClick = { onClickIndexBtn(4) }
                        )
                        Button(
                            content = {
                                Text(text = "5")
                            },
                            onClick = { onClickIndexBtn(5) }
                        )
                    }
                }
            }
        }
        else -> {
            CottonLoadingView(
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}

@Composable
fun NewsCard(
    modifier: Modifier = Modifier,
    news: ValEsportsNews,
    onClickCard: (ValEsportsNews) -> Unit = {}
) {

    val flag = news.flagISO?.let { FlagKit.getResId(LocalContext.current, it) }

    Card(
        modifier = modifier,
        elevation = 4.dp
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .clickable { onClickCard(news) }
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
                if (flag != null && flag != 0x0) {
                    Image(
                        modifier = Modifier,
                        painter = painterResource(id = flag),
                        contentDescription = null
                    )
                } else {
                    Text(
                        modifier = Modifier,
                        text = news.flagISO?.uppercase().orEmpty(),
                        color = Color.Gray,
                        style = MaterialTheme.typography.caption
                    )
                }
                Text(
                    modifier = Modifier.padding(start = 4.dp),
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

@Preview(showBackground = true)
@Composable
fun NewsScreenSuccessPreview() {
    NewsScreen(
        newsUiState = NewsUiState.Success(
            listOf(
                ValEsportsNews(
                    title = "Gen.G reveal all-Korean  123123 ",
                    description = "VLR.gg's roster tracker keeps up to date on roster moves in the Pacific region in view of the upcome asdfasdfasdfasdfasdfasdfasdf",
                    flagISO = "KR",
                    date = "November 22, 2022",
                    writer = "Dr.Sun Cotton"
                ),
                ValEsportsNews(
                    title = "Gen.G reveal all-Korean roste 222 r",
                    description = "VLR.gg's roster tracker keeps up to date on roster moves in the Pacific region in view of the upcome asdfasdfasdfasdfasdfasdfasdf",
                    flagISO = "KR",
                    date = "October 22, 2022",
                    writer = "Dr.Sun Cotton"
                ),
                ValEsportsNews(
                    title = "Gen.G reveal all-Korean roster",
                    description = "VLR.gg's roster tracker keeps up to date on roster moves in the Pacific region in view of the upcome asdfasdfasdfasdfasdfasdfasdf",
                    flagISO = "KR",
                    date = "October 22, 2022",
                    writer = "Dr.Sun Cotton"
                )
            )
        ),
        onClickItem = {},
        onClickIndexBtn = {}
    )
}

@Preview(showBackground = true)
@Composable
fun NewsScreenLoadingPreview() {
    NewsScreen(
        newsUiState = NewsUiState.Loading,
        onClickItem = {},
        onClickIndexBtn = {}
    )
}

@Preview(showBackground = true)
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