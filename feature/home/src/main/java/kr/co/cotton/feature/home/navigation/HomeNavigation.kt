package kr.co.cotton.feature.home.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavController
import androidx.navigation.compose.composable
import kr.co.cotton.feature.home.HomeRoute

const val homeRoute = "home"

fun NavGraphBuilder.homeScreen(navController: NavController) {
    composable(route = homeRoute) {
        HomeRoute(
            navController = navController
        )
    }
}
