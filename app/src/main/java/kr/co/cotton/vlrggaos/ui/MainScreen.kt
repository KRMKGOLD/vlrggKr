package kr.co.cotton.vlrggaos.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import kr.co.cotton.news.navigation.newsRoute
import kr.co.cotton.vlrggaos.R
import kr.co.cotton.vlrggaos.navigation.MainNavHost

@Composable
fun MainScreen(
    navController: NavHostController = rememberNavController()
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            MainBottomNavigation(navController = navController)
        }
    ) {
        Box(modifier = Modifier.padding(it)) {
            MainNavHost(navController = navController)
        }
    }
}

sealed class MainBottomNavItem(
    val icon: Int, val title: Int, val screenRoute: String
) {

    object News : MainBottomNavItem(
        R.drawable.ic_launcher_background,
        R.string.text_news,
        newsRoute
    )

    object Matches : MainBottomNavItem(
        R.drawable.ic_launcher_background,
        R.string.text_matches,
        "/matches"
    )

    object Search : MainBottomNavItem(
        R.drawable.ic_launcher_background,
        R.string.text_search,
        "/search"
    )
}

@Composable
fun MainBottomNavigation(navController: NavController) {
    val items = listOf(
        MainBottomNavItem.News,
        MainBottomNavItem.Matches,
        MainBottomNavItem.Search
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    BottomNavigation(
        backgroundColor = Color.White
    ) {
        items.forEach { item ->
            BottomNavigationItem(
                icon = {
                    Icon(
                        modifier = Modifier
                            .size(24.dp)
                            .padding(12.dp),
                        painter = painterResource(item.icon),
                        contentDescription = stringResource(item.title)
                    )
                },
                label = {
                    Text(
                        text = stringResource(item.title),
                        fontSize = 10.sp
                    )
                },
                selected = currentRoute == item.screenRoute,
                onClick = {
                    navController.navigate(item.screenRoute) {
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) { saveState = true }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}

const val News = "NEWS"
const val Matches = "MATCHES"
const val Search = "SEARCH"