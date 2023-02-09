package kr.co.cotton.feature.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import kr.co.cotton.core.designsystem.component.common.CottonScaffold
import kr.co.cotton.core.designsystem.component.common.CottonTopBar
import kr.co.cotton.core.designsystem.component.theme.CottonTheme
import kr.co.cotton.feature.news.navigation.navigateToNews
import kr.co.cotton.feature.search.navigation.navigateToSearch

@Composable
fun HomeRoute(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    HomeScreen(
        modifier = modifier,
        navController = navController
    )
}

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {

    CottonScaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            CottonTopBar(
                title = "Vlr.gg Unoffical",
                onClickBackBtn = { navController.popBackStack() },
                onClickSearchBtn = { navController.navigateToSearch() }
            )
        }
    ) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                        .padding(end = 8.dp)
                        .weight(1f),
                    content = {
                        Text(text = "News")
                    },
                    onClick = { navController.navigateToNews() }
                )
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                        .padding(start = 8.dp)
                        .weight(1f),
                    content = {
                        Text(text = "Matches")
                    },
                    onClick = { navController.navigate("matches") }
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                        .padding(end = 8.dp)
                        .weight(1f),
                    content = {
                        Text(text = "Search")
                    },
                    onClick = { navController.navigate("search") }
                )
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                        .padding(start = 8.dp)
                        .weight(1f),
                    content = {
                        Text(text = "NOTHING")
                    },
                    onClick = {}
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    CottonTheme {
        HomeScreen(
            navController = rememberNavController(),
        )
    }
}
