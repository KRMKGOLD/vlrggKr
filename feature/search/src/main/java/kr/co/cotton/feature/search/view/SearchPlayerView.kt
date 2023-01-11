package kr.co.cotton.feature.search.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import kr.co.cotton.core.data.search.model.SearchResult
import kr.co.cotton.core.designsystem.component.common.CottonCard
import kr.co.cotton.core.designsystem.component.theme.CottonTheme

@Composable
fun SearchPlayerView(
    modifier: Modifier = Modifier,
    searchPlayer: SearchResult.SearchPlayer,
    onClickCard: (SearchResult.SearchPlayer) -> Unit
) {
    CottonCard(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onClickCard(searchPlayer) },
        elevation = 4.dp
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            AsyncImage(
                modifier = Modifier.size(60.dp),
                model = ImageRequest.Builder(LocalContext.current)
                    .data(searchPlayer.imgSrc)
                    .crossfade(true)
                    .build(),
                contentDescription = null
            )
            Column(
                modifier = Modifier
                    .padding(start = 8.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    style = MaterialTheme.typography.bodyLarge,
                    text = searchPlayer.nickname.orEmpty()
                )
                if (!searchPlayer.realName.isNullOrEmpty()) {
                    Text(
                        modifier = Modifier
                            .padding(top = 4.dp)
                            .fillMaxWidth(),
                        style = MaterialTheme.typography.bodyMedium,
                        text = searchPlayer.realName.orEmpty()
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SearchPlayerViewPreview() {
    CottonTheme {
        SearchPlayerView(
            searchPlayer = SearchResult.SearchPlayer(
                imgSrc = "https://www.shutterstock.com/image-vector/fake-rubber-stamp-grunge-seal-260nw-1427510693.jpg",
                href = "href",
                url = "url",
                nickname = "MaKo",
                realName = "Kim Myeong-gwan (김명관)"
            ),
            onClickCard = {}
        )
    }
}