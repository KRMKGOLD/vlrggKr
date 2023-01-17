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
fun SearchTeamView(
    modifier: Modifier = Modifier,
    searchTeam: SearchResult.SearchTeam,
    onClickCard: (SearchResult.SearchTeam) -> Unit
) {
    CottonCard(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onClickCard(searchTeam) },
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
                    .data(searchTeam.imgSrc)
                    .crossfade(true)
                    .build(),
                contentDescription = null
            )
            Column(
                modifier = Modifier
                    .padding(start = 4.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    style = MaterialTheme.typography.bodyLarge,
                    text = searchTeam.name.orEmpty()
                )
                Text(
                    modifier = Modifier
                        .padding(top = 4.dp)
                        .fillMaxWidth(),
                    style = MaterialTheme.typography.bodyMedium,
                    text = searchTeam.inactiveStr.orEmpty()
                )

                Text(
                    modifier = Modifier
                        .padding(top = 4.dp)
                        .fillMaxWidth(),
                    style = MaterialTheme.typography.bodyMedium,
                    text = searchTeam.prevOrCurrentStr.orEmpty()
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SearchTeamViewPreview() {
    CottonTheme {
        SearchTeamView(
            searchTeam = SearchResult.SearchTeam(
                name = "Vision Strikers",
                inactiveStr = "inactive since January 7, 2022",
                prevOrCurrentStr = "currently DRX"
            )
        ) {}
    }
}