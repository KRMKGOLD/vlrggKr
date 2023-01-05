package kr.co.cotton.feature.search.navigation

import androidx.navigation.*
import androidx.navigation.compose.composable
import kr.co.cotton.feature.search.SearchRoute

const val searchRoute = "search"

fun NavController.navigateToSearch(navOptions: NavOptions? = null) {
    this.navigate(searchRoute, navOptions)
}

fun NavGraphBuilder.searchScreen(navController: NavController) {
    composable(searchRoute) {
        SearchRoute(
            navController = navController
        )
    }
}