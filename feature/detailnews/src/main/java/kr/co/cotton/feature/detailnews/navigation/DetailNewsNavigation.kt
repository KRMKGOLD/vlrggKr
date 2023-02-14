package kr.co.cotton.feature.detailnews.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import kr.co.cotton.feature.detailnews.DetailNewsRoute

const val detailNewsRoute = "detailnews/{nId}/{title}"

fun NavController.navigateToDetailNews(navOptions: NavOptions? = null, href: String) {
    this.navigate("detailnews$href", navOptions)
}

fun NavGraphBuilder.detailNewsScreen(navController: NavController) {
    composable(
        route = detailNewsRoute,
        arguments = listOf(
            navArgument("nId") { type = NavType.StringType },
            navArgument("title") { type = NavType.StringType },
        ),
    ) {
        DetailNewsRoute(navController = navController)
    }
}
