package kr.co.cotton.vlrggaos.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import kr.co.cotton.news.navigation.newsScreen

@Composable
fun MainNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = MainNavigationItem.Main.screenRoute
    ) {
        mainScreen(navController)
        newsScreen(navController)
        composable(MainNavigationItem.Matches.screenRoute) {
            // TODO : MatchesScreen
        }
        composable(MainNavigationItem.Search.screenRoute) {
            // TODO : SearchScreen
        }
    }
}