package kr.co.cotton.feature.search.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import kr.co.cotton.core.data.search.model.SearchResult
import kr.co.cotton.core.designsystem.component.common.CottonCard
import kr.co.cotton.core.designsystem.component.theme.CottonTheme
import kr.co.cotton.core.designsystem.component.theme.prize_pool_color

@Composable
fun SearchEventView(
    modifier: Modifier = Modifier,
    searchEvent: SearchResult.SearchEvent,
    onClickCard: (SearchResult.SearchEvent) -> Unit
) {
    CottonCard(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onClickCard(searchEvent) },
        elevation = 4.dp
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            AsyncImage(
                modifier = Modifier.size(80.dp),
                model = ImageRequest.Builder(LocalContext.current)
                    .data(searchEvent.imgSrc)
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
                    text = searchEvent.title.orEmpty()
                )
                Row(
                    modifier = Modifier
                        .padding(top = 8.dp)
                        .fillMaxWidth()
                ) {
                    Text(
                        style = MaterialTheme.typography.bodyMedium,
                        text = searchEvent.eventPeriod.orEmpty()
                    )
                    Text(
                        modifier = Modifier
                            .padding(start = 8.dp),
                        style = MaterialTheme.typography.bodyMedium,
                        text = searchEvent.prizePool.orEmpty(),
                        color = prize_pool_color
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SearchEventViewPreview() {
    CottonTheme {
        SearchEventView(
            searchEvent = SearchResult.SearchEvent(
                title = "EVENT TITLE",
                eventPeriod = "12/30 ~ 1/30",
                prizePool = "$120"
            ),
            onClickCard = {}
        )
    }
}