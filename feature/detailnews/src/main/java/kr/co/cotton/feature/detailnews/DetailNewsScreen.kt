package kr.co.cotton.feature.detailnews

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
internal fun DetailNewsRoute(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: DetailNewsViewModel = hiltViewModel(),
) {

    DetailNewsScreen(
        modifier = modifier,
        navController = navController,
    )
}

@Composable
fun DetailNewsScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
) {

}

@Preview(showBackground = true)
@Composable
fun DetailNewsScreenPreview() {
    DetailNewsScreen(
        navController = rememberNavController(),
    )
}
