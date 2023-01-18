package kr.co.cotton.feature.search

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import kr.co.cotton.core.data.search.model.SearchResult
import kr.co.cotton.core.designsystem.component.common.CottonErrorView
import kr.co.cotton.core.designsystem.component.common.CottonLoadingView
import kr.co.cotton.core.designsystem.component.common.CottonScaffold
import kr.co.cotton.core.designsystem.component.common.CottonTopBar
import kr.co.cotton.core.designsystem.component.theme.CottonTheme
import kr.co.cotton.feature.search.view.SearchEventView
import kr.co.cotton.feature.search.view.SearchPlayerView
import kr.co.cotton.feature.search.view.SearchSeriesView
import kr.co.cotton.feature.search.view.SearchTeamView

@Composable
internal fun SearchRoute(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: SearchViewModel = hiltViewModel()
) {
    val searchListUiState by viewModel.searchListUiState.collectAsState()

    SearchScreen(
        modifier = modifier,
        navController = navController,
        searchListUiState = searchListUiState,
        onClickSearchButton = viewModel::getSearchData
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    searchListUiState: SearchListUiState,
    onClickSearchButton: (String) -> Unit
) {
    var searchQuery by remember {
        mutableStateOf("")
    }

    CottonScaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            CottonTopBar(
                title = "Search",
                onClickBackBtn = { navController.popBackStack() }
            )
        }
    ) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = searchQuery,
                onValueChange = { searchQuery = it },
                label = { Text(text = "Search...") },
                trailingIcon = {
                    Icon(
                        modifier = Modifier
                            .clickable { onClickSearchButton(searchQuery) },
                        imageVector = Icons.Filled.Search,
                        contentDescription = null
                    )
                }
            )
            Divider(
                modifier = Modifier.padding(top = 16.dp),
                thickness = 2.dp
            )
            Text(
                modifier = Modifier.padding(top = 8.dp),
                text = "FOUND 0 RESULTS",
                style = MaterialTheme.typography.labelMedium
            )
            LazyColumn(
                modifier = Modifier
                    .padding(top = 8.dp)
                    .fillMaxSize()
            ) {
                when (searchListUiState) {
                    is SearchListUiState.Success -> {
                        items(searchListUiState.news) { searchResult ->
                            val itemModifier = Modifier.padding(top = 16.dp)

                            when (searchResult) {
                                is SearchResult.SearchEvent -> SearchEventView(
                                    modifier = itemModifier,
                                    searchEvent = searchResult,
                                    onClickCard = {}
                                )
                                is SearchResult.SearchPlayer -> SearchPlayerView(
                                    modifier = itemModifier,
                                    searchPlayer = searchResult,
                                    onClickCard = {}
                                )
                                is SearchResult.SearchSeries -> SearchSeriesView(
                                    modifier = itemModifier,
                                    searchSeries = searchResult,
                                    onClickCard = {}
                                )
                                is SearchResult.SearchTeam -> SearchTeamView(
                                    modifier = itemModifier,
                                    searchTeam = searchResult,
                                    onClickCard = {}
                                )
                            }
                        }
                    }
                    SearchListUiState.Loading -> {
                        item {
                            CottonLoadingView(
                                modifier = Modifier.fillMaxSize()
                            )
                        }
                    }
                    SearchListUiState.Error -> {
                        item {
                            CottonErrorView(
                                modifier = Modifier.fillMaxSize(),
                                errorTitle = "Error!",
                                errorMessage = "Failed to get data. Please try again later."
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SearchScreenPreview() {
    CottonTheme {
        SearchScreen(
            navController = rememberNavController(),
            onClickSearchButton = {},
            searchListUiState = SearchListUiState.Loading,
        )
    }
}