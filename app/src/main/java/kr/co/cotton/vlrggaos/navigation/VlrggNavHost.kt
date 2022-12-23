package kr.co.cotton.vlrggaos.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import kr.co.cotton.feature.home.navigation.homeRoute
import kr.co.cotton.feature.home.navigation.homeScreen
import kr.co.cotton.feature.news.navigation.newsScreen

@Composable
fun MainNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = homeRoute
    ) {
        homeScreen(navController)
        newsScreen(navController)
        composable("matches") {
            // TODO : MatchesScreen
        }
        composable("search") {
            // TODO : SearchScreen
        }
    }
}
