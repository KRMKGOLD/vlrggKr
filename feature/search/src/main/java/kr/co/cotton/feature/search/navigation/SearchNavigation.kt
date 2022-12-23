package kr.co.cotton.feature.search.navigation

import androidx.navigation.*
import androidx.navigation.compose.composable
import kr.co.cotton.feature.search.SearchRoute

const val searchRoute = "search/{searchValue}"

fun NavController.navigateToSearch(searchValue: String, navOptions: NavOptions? = null) {
    this.navigate("search/${searchValue}", navOptions)
}

fun NavGraphBuilder.searchScreen(navController: NavController) {
    composable(
        route = searchRoute,
        arguments = listOf(navArgument("searchValue") { type = NavType.StringType })
    ) { backStackEntry ->
        val searchValue = backStackEntry.arguments?.getString("searchValue")
        SearchRoute(
            navController = navController,
            searchValue = searchValue.orEmpty()
        )
    }
}