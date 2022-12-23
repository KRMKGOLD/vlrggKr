package kr.co.cotton.feature.search.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import kr.co.cotton.feature.search.SearchRoute

const val searchRoute = "/search/{searchValue}"

fun NavController.navigateToSearch(navOptions: NavOptions? = null) {
    this.navigate(searchRoute, navOptions)
}

fun NavGraphBuilder.navigateToSearch(navController: NavController) {
    composable(route = searchRoute) {
        SearchRoute(navController = navController)
    }
}