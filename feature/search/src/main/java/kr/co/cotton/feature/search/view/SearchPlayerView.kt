package kr.co.cotton.feature.search.view

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
        modifier = modifier.fillMaxWidth(),
        elevation = 4.dp
    ) {

    }
}

@Preview(showBackground = true)
@Composable
fun SearchPlayerViewPreview() {
    CottonTheme {
        SearchPlayerView(
            searchPlayer = SearchResult.SearchPlayer(),
            onClickCard = {}
        )
    }
}