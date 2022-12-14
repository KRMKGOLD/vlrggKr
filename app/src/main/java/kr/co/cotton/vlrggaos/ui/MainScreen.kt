package kr.co.cotton.vlrggaos.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import kr.co.cotton.designsystem.component.CottonTopBar
import kr.co.cotton.vlrggaos.MainViewModel
import kr.co.cotton.vlrggaos.navigation.MainNavHost
import kr.co.cotton.vlrggaos.navigation.MainNavigationItem

@Composable
fun HomeScreen(
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

@Composable
fun MainRoute(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    viewModel: MainViewModel = hiltViewModel()
) {
    MainScreen(
        modifier = modifier,
        navController = navController
    )
}

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    Column(modifier = modifier.padding(16.dp)) {
        Button(
            content = {
                Text(
                    text = stringResource(id = MainNavigationItem.News.title)
                )
            },
            onClick = {
                navController.navigate(MainNavigationItem.News.screenRoute)
            }
        )
        Button(
            content = {
                Text(
                    text = stringResource(id = MainNavigationItem.Matches.title)
                )
            },
            onClick = {
                navController.navigate(MainNavigationItem.Matches.screenRoute)
            }
        )
        Button(
            content = {
                Text(
                    text = stringResource(id = MainNavigationItem.Search.title)
                )
            },
            onClick = {
                navController.navigate(MainNavigationItem.Search.screenRoute)
            }
        )
    }

}
