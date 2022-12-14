package kr.co.cotton.vlrggaos.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import kr.co.cotton.news.navigation.newsRoute
import kr.co.cotton.vlrggaos.R
import kr.co.cotton.vlrggaos.ui.MainRoute

const val mainRoute = "/main"

fun NavGraphBuilder.mainScreen(navController: NavHostController) {
    composable(route = mainRoute) {
        MainRoute(
            navController = navController
        )
    }
}

sealed class MainNavigationItem(
    val title: Int, val screenRoute: String
) {

    object Main : MainNavigationItem(
        R.string.text_main,
        mainRoute
    )

    object News : MainNavigationItem(
        R.string.text_news,
        newsRoute
    )

    object Matches : MainNavigationItem(
        R.string.text_matches,
        "/matches"
    )

    object Search : MainNavigationItem(
        R.string.text_search,
        "/search"
    )
}