package kr.co.cotton.vlrggaos.ui.theme

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import kr.co.cotton.vlrggaos.R

val fonts = FontFamily(
    Font(R.font.spoqa_han_sans_neo_bold, weight = FontWeight.Bold),
    Font(R.font.spoqa_han_sans_neo_medium, weight = FontWeight.Medium),
    Font(R.font.spoqa_han_sans_neo_regular, weight = FontWeight.Normal),
    Font(R.font.spoqa_han_sans_neo_light, weight = FontWeight.Light),
    Font(R.font.spoqa_han_sans_neo_thin, weight = FontWeight.Thin)
)

val Bold = TextStyle(
    fontFamily = fonts,
    fontWeight = FontWeight.Bold,
    color = Color.Black
)

val Medium = TextStyle(
    fontFamily = fonts,
    fontWeight = FontWeight.Medium,
    color = Color.Black
)

val Normal = TextStyle(
    fontFamily = fonts,
    fontWeight = FontWeight.Normal,
    color = Color.Black
)

val Light = TextStyle(
    fontFamily = fonts,
    fontWeight = FontWeight.Light,
    color = Color.Black
)

val Thin = TextStyle(
    fontFamily = fonts,
    fontWeight = FontWeight.Thin,
    color = Color.Black
)