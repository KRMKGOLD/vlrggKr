package kr.co.cotton.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
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


@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
) {

    val searchValue by remember {
        mutableStateOf("")
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = searchValue,
            label = {
                Text(text = "Search...")
            },
            onValueChange = {},
            maxLines = 1,
            textStyle = TextStyle(color = Color.Black, fontWeight = FontWeight.Medium),
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
//            keyboardActions = KeyboardActions(onSearch =)
//            TODO : KeyboardAction 클릭 시 Search 화면으로 이동
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                content = {
                    Text(text = "News")
                },
                onClick = { navController.navigateToNews() }
            )
            Button(
                modifier = Modifier
                    .fillMaxWidth()
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
                .padding(top = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                content = {
                    Text(text = "Search")
                },
                onClick = { navController.navigate("search") }
            )
            Button(
                modifier = Modifier
                    .fillMaxWidth()
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
    MainScreen(
        navController = rememberNavController()
    )
}
