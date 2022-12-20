package kr.co.cotton.designsystem.component.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import kr.co.cotton.designsystem.R

val spoqaHanSansNeoFontFamily = FontFamily(
    Font(R.font.spoqa_han_sans_neo_bold, weight = FontWeight.Bold),
    Font(R.font.spoqa_han_sans_neo_medium, weight = FontWeight.Medium),
    Font(R.font.spoqa_han_sans_neo_regular, weight = FontWeight.Normal),
    Font(R.font.spoqa_han_sans_neo_light, weight = FontWeight.Light),
    Font(R.font.spoqa_han_sans_neo_thin, weight = FontWeight.Thin)
)

val CottonTypography = Typography(
    defaultFontFamily = spoqaHanSansNeoFontFamily
)