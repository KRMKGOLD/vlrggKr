package kr.co.cotton.feature.home

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import kr.co.cotton.core.designsystem.component.theme.CottonTheme
import kr.co.cotton.feature.news.navigation.navigateToNews

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {

    var searchValue by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = searchValue,
            onValueChange = {},
            label = {
                Text(text = "Search...")
            },
            enabled = false
        )
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

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    CottonTheme {
        HomeScreen(
            navController = rememberNavController(),
        )
    }
}
