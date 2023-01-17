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

@Composable
fun SearchSeriesView(
    modifier: Modifier = Modifier,
    searchSeries: SearchResult.SearchSeries,
    onClickCard: (SearchResult.SearchSeries) -> Unit
) {
    CottonCard(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onClickCard(searchSeries) },
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
                    .data(searchSeries.imgSrc)
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
                    text = searchSeries.title.orEmpty()
                )
                Text(
                    modifier = Modifier
                        .padding(top = 8.dp),
                    style = MaterialTheme.typography.bodyMedium,
                    text = "Series"
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SearchSeriesViewPreview() {
    CottonTheme {
        SearchSeriesView(
            searchSeries = SearchResult.SearchSeries(
                title = "TEST"
            )
        ) { }
    }
}
