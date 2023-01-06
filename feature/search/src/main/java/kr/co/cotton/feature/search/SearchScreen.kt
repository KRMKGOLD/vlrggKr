package kr.co.cotton.feature.search

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import kr.co.cotton.core.designsystem.component.CottonLoadingView
import kr.co.cotton.core.designsystem.component.theme.CottonTheme

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
            },
        )
        Divider(
            modifier = Modifier.padding(top = 16.dp),
            color = MaterialTheme.colors.primary,
            thickness = 2.dp
        )
        Text(
            modifier = Modifier.padding(top = 8.dp),
            text = "FOUND 0 RESULTS",
            color = MaterialTheme.colors.primaryVariant,
            fontSize = 12.sp
        )
        LazyColumn(
            modifier = Modifier
                .padding(top = 8.dp)
                .fillMaxSize()
        ) {
            when (searchListUiState) {
                is SearchListUiState.Success -> {
                    items(searchListUiState.news) { searchResult ->
                        Text(text = searchResult.url.orEmpty())
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
                        CottonLoadingView(
                            modifier = Modifier.fillMaxSize()
                        )
                        // TODO : CottonErrorView()
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