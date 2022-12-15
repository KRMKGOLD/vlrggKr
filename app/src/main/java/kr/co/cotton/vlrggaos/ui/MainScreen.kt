package kr.co.cotton.vlrggaos.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import kr.co.cotton.designsystem.component.CottonTopBar
import kr.co.cotton.vlrggaos.navigation.MainNavHost

@Composable
fun MainScreen(
    navController: NavHostController = rememberNavController()
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            CottonTopBar(
                title = "Vlr.gg Unoffical",
                onClickBackBtn = { navController.popBackStack() }
            )
        }
    ) {
        Column(modifier = Modifier.padding(it)) {
            MainNavHost(navController = navController)
        }
    }
}

