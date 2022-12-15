package kr.co.cotton.news.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import kr.co.cotton.news.NewsRoute

const val newsRoute = "/news"

fun NavController.navigateToNews(navOptions: NavOptions? = null) {
    this.navigate(newsRoute, navOptions)
}

fun NavGraphBuilder.newsScreen(navController: NavHostController) {
    composable(route = newsRoute) {
        NewsRoute(navController = navController)
    }
}
