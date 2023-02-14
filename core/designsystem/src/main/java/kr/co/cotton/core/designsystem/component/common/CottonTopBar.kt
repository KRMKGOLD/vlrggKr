package kr.co.cotton.core.designsystem.component.common

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import kr.co.cotton.core.designsystem.component.theme.CottonTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CottonTopBar(
    title: String = "",
    onClickBackBtn: (() -> Unit)? = null,
    onClickSearchBtn: (() -> Unit)? = null,
) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium,
            )
        },
        navigationIcon = {
            if (onClickBackBtn != null) {
                IconButton(
                    onClick = { onClickBackBtn() },
                ) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = null,
                    )
                }
            }
        },
        actions = {
            if (onClickSearchBtn != null) {
                IconButton(
                    onClick = { onClickSearchBtn() },
                ) {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = null,
                    )
                }
            }
        },
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
            onClickBackBtn = { },
        )
    }
}
