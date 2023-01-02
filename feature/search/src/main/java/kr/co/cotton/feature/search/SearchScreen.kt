package kr.co.cotton.feature.search

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@Composable
internal fun SearchRoute(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: SearchViewModel = hiltViewModel()
) {
    SearchScreen(
        modifier = modifier,
        navController = navController
    )
}

@Composable
fun SearchScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
) {
    val searchValue by remember {
        mutableStateOf("")
    }

    Column(
        modifier = modifier
    ) {
        Text(text = searchValue)
    }
}