package kr.co.cotton.feature.home.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import kr.co.cotton.feature.home.HomeRoute

const val homeRoute = "home"

fun NavGraphBuilder.homeScreen(navController: NavHostController) {
    composable(route = homeRoute) {
        HomeRoute(
            navController = navController
        )
    }
}
