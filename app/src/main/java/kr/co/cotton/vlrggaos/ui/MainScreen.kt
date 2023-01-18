package kr.co.cotton.vlrggaos.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import kr.co.cotton.vlrggaos.navigation.MainNavHost

@Composable
fun MainScreen(
    navController: NavHostController = rememberNavController()
) {
    Column(modifier = Modifier.fillMaxSize()) {
        MainNavHost(navController = navController)
    }
}
