package kr.co.cotton.news

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.murgupluoglu.flagkit.FlagKit
import kr.co.cotton.data.model.ValEsportsNews
import kr.co.cotton.designsystem.component.CottonLoadingView

@Composable
internal fun NewsRoute(
    modifier: Modifier = Modifier,
    viewModel: NewsViewModel = hiltViewModel()
) {
    val lazyPagingItems = viewModel.newsListFlow.collectAsLazyPagingItems()
    val context = LocalContext.current

    NewsScreen(
        modifier = modifier,
        lazyPagingItems = lazyPagingItems,
        onClickItem = {
            ContextCompat.startActivity(
                context,
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse(it.url)
                ),
                null
            )
        }
    )
}

@Composable
fun NewsScreen(
    modifier: Modifier = Modifier,
    lazyPagingItems: LazyPagingItems<ValEsportsNews>,
    onClickItem: (ValEsportsNews) -> Unit
) {
    val state = rememberLazyListState()

    LazyColumn(
        modifier = modifier,
        state = state,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(lazyPagingItems) { news ->
            if (news != null) {
                NewsCard(
                    modifier = Modifier.padding(top = 16.dp, start = 16.dp, end = 16.dp),
                    news = news,
                    onClickCard = onClickItem
                )
            }
        }

        lazyPagingItems.apply {
            when {
                loadState.refresh is LoadState.Loading || loadState.append is LoadState.Loading -> {
                    item {
                        CottonLoadingView(
                            modifier = Modifier
                                .fillParentMaxSize()
                                .padding(vertical = 16.dp)
                        )
                    }
                }
                loadState.refresh is LoadState.Error || loadState.append is LoadState.Error -> {
                    val e = lazyPagingItems.loadState.refresh as LoadState.Error
                    item {
                        Text(
                            modifier = Modifier.fillParentMaxSize(),
                            text = e.error.localizedMessage!!,
                        )
                    }
                }
            }
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
        if (news.isDataEmpty) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
            ) {
                CottonLoadingView(modifier = Modifier.fillMaxWidth())
            }
        } else {
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