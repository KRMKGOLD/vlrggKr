package kr.co.cotton.vlrggaos.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import kr.co.cotton.news.navigation.newsScreen
import kr.co.cotton.vlrggaos.ui.MainBottomNavItem

@Composable
fun MainNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = MainBottomNavItem.News.screenRoute
    ) {
        newsScreen()
        composable(MainBottomNavItem.Matches.screenRoute) {
            // TODO : MatchesScreen
        }
        composable(MainBottomNavItem.Search.screenRoute) {
            // TODO : SearchScreen
        }
    }
}