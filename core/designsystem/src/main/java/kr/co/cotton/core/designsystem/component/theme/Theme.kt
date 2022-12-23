package kr.co.cotton.core.designsystem.component.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val LightColorPalette = lightColors(
    primary = Gray500,
    primaryVariant = Gray700
)

@Composable
fun CottonTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colors = LightColorPalette,
        typography = CottonTypography,
        shapes = CottonShape,
        content = content
    )
}