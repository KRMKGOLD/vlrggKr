package com.example.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import kr.co.cotton.news.navigation.navigateToNews

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    Column(modifier = modifier.padding(16.dp)) {
        Button(
            content = {
                Text(
                    text = "News"
                )
            },
            onClick = {
                navController.navigateToNews()
            }
        )
        Button(
            content = {
                Text(
                    text = "Matches"
                )
            },
            onClick = {
                navController.navigate("matches")
            }
        )
        Button(
            content = {
                Text(
                    text = "Search"
                )
            },
            onClick = {
                navController.navigate("search")
            }
        )
    }
}