package kr.co.cotton.news.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import kr.co.cotton.news.NewsRoute

const val newsRoute = "/news"

fun NavGraphBuilder.newsScreen(navController: NavHostController) {
    composable(route = newsRoute) {
        NewsRoute(navController = navController)
    }
}
