package kr.co.cotton.core.designsystem.component

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kr.co.cotton.core.designsystem.component.theme.CottonTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CottonTopBar(
    title: String,
    onClickBackBtn: (() -> Unit)? = null,
    onClickSearchBtn: (() -> Unit)? = null
) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = title,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        },
        navigationIcon = {
            if (onClickBackBtn != null) {
                IconButton(
                    onClick = { onClickBackBtn() }
                ) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = null
                    )
                }
            }
        },
        actions = {
            if (onClickSearchBtn != null) {
                IconButton(
                    onClick = { onClickSearchBtn() }
                ) {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = null
                    )
                }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun CottonTopBarPreview() {
    CottonTheme {
        CottonTopBar("Test Title")
    }
}

@Preview(showBackground = true)
@Composable
fun CottonTopBarPreview2() {
    CottonTheme {
        CottonTopBar(
            title = "Test Title",
            onClickBackBtn = { }
        )
    }
}