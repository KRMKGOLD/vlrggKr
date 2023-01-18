package kr.co.cotton.feature.home

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import kr.co.cotton.core.designsystem.component.common.CottonScaffold
import kr.co.cotton.core.designsystem.component.common.CottonTopBar
import kr.co.cotton.core.designsystem.component.theme.CottonTheme
import kr.co.cotton.feature.news.navigation.navigateToNews
import kr.co.cotton.feature.search.navigation.navigateToSearch

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController
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
