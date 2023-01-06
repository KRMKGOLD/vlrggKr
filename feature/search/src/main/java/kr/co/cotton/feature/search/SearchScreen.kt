package kr.co.cotton.feature.search

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import kr.co.cotton.core.designsystem.component.theme.CottonTheme

@Composable
internal fun SearchRoute(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: SearchViewModel = hiltViewModel()
) {
    SearchScreen(
        modifier = modifier,
        navController = navController,
        onClickSearchButton = viewModel::getSearchData
    )
}

@Composable
fun SearchScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
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
            fontSize = 14.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SearchScreenPreview() {
    CottonTheme {
        SearchScreen(
            navController = rememberNavController(),
            onClickSearchButton = {}
        )
    }
}