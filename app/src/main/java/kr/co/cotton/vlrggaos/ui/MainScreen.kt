package kr.co.cotton.vlrggaos.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import kr.co.cotton.core.designsystem.component.common.CottonTopBar
import kr.co.cotton.feature.search.navigation.navigateToSearch
import kr.co.cotton.vlrggaos.navigation.MainNavHost

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    navController: NavHostController = rememberNavController()
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            CottonTopBar(
                title = "Vlr.gg Unoffical",
                onClickBackBtn = { navController.popBackStack() },
                onClickSearchBtn = { navController.navigateToSearch() }
            )
        }
    ) {
        Column(modifier = Modifier.padding(it)) {
            MainNavHost(navController = navController)
        }
    }
}

