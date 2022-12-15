package kr.co.cotton.home.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import kr.co.cotton.home.HomeScreen

@Composable
fun HomeRoute(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    HomeScreen(
        modifier = modifier,
        navController = navController
    )
}