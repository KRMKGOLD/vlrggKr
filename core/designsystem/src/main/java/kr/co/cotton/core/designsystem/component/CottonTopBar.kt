package kr.co.cotton.core.designsystem.component

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CottonTopBar(
    title: String,
    onClickBackBtn: (() -> Unit)? = null
) {
    TopAppBar(
        elevation = 4.dp,
        title = {
            Text(text = title)
        },
        backgroundColor = MaterialTheme.colors.primarySurface,
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
        }
    )
}

@Preview(showBackground = true)
@Composable
fun CottonTopBarPreview() {
    CottonTopBar("Test Title")
}

@Preview(showBackground = true)
@Composable
fun CottonTopBarPreview2() {
    CottonTopBar(
        title = "Test Title",
        onClickBackBtn = { }
    )
}