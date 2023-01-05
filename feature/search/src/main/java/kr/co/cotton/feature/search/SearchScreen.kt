package kr.co.cotton.feature.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import kr.co.cotton.core.designsystem.component.theme.CottonTheme

@Composable
internal fun SearchRoute(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: SearchViewModel = hiltViewModel()
) {
    var searchValue by remember { mutableStateOf("") }

    SearchScreen(
        modifier = modifier,
        navController = navController
    )
}

@Composable
fun SearchScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
) {
    var searchValue by remember {
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
            onValueChange = { searchValue = it },
            label = { Text(text = "Search...") },
            enabled = false
        )
        Divider(
            modifier = Modifier.padding(top = 16.dp),
            color = MaterialTheme.colors.primary,
            thickness = 2.dp
        )
        Text(
            modifier = Modifier.padding(top = 8.dp),
            text = "FOUND 0 RESULTS",
            color = MaterialTheme.colors.primaryVariant,
            fontSize = 14.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SearchScreenPreview() {
    CottonTheme {
        SearchScreen(navController = rememberNavController())
    }
}