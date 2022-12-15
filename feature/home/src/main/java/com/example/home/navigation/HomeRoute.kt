package com.example.home.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.home.HomeScreen

@Composable
fun HomeRoute(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    HomeScreen(
        modifier = modifier,
        navController = navController
    )
}