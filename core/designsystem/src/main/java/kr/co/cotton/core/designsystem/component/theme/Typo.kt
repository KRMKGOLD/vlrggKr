package kr.co.cotton.core.designsystem.component.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import kr.co.cotton.core.designsystem.R

val spoqaHanSansNeoFontFamily = FontFamily(
    Font(R.font.spoqa_han_sans_neo_bold, weight = FontWeight.Bold),
    Font(R.font.spoqa_han_sans_neo_medium, weight = FontWeight.Medium),
    Font(R.font.spoqa_han_sans_neo_regular, weight = FontWeight.Normal),
    Font(R.font.spoqa_han_sans_neo_light, weight = FontWeight.Light),
    Font(R.font.spoqa_han_sans_neo_thin, weight = FontWeight.Thin)
)

/**
 * Title Large : 22sp, Normal
 *
 * Title Medium : 16sp, Medium
 *
 * Title Small : 14sp, Medium
 *
 * Body Large : 16sp, Normal
 *
 * Body Medium : 14sp, Normal
 *
 * Body Small : 12sp, Normal
 *
 * Label Large = 14sp, Medium
 *
 * Label Medium = 12sp, Medium
 *
 * Label Small = 11sp, Medium
 */
val CottonTypography = Typography(
    titleLarge = TextStyle(
        fontFamily = spoqaHanSansNeoFontFamily,
        lineHeight = 28.sp,
        fontSize = 22.sp,
        letterSpacing = 0.0.sp,
        fontWeight = FontWeight.Normal
    ),
    titleMedium = TextStyle(
        fontFamily = spoqaHanSansNeoFontFamily,
        lineHeight = 24.sp,
        fontSize = 16.sp,
        letterSpacing = 0.0.sp,
        fontWeight = FontWeight.Medium
    ),
    titleSmall = TextStyle(
        fontFamily = spoqaHanSansNeoFontFamily,
        lineHeight = 20.0.sp,
        fontSize = 14.sp,
        letterSpacing = 0.1.sp,
        fontWeight = FontWeight.Medium
    ),
    bodyLarge = TextStyle(
        fontFamily = spoqaHanSansNeoFontFamily,
        lineHeight = 24.0.sp,
        fontSize = 16.sp,
        letterSpacing = 0.5.sp,
        fontWeight = FontWeight.Normal
    ),
    bodyMedium = TextStyle(
        fontFamily = spoqaHanSansNeoFontFamily,
        lineHeight = 20.0.sp,
        fontSize = 14.sp,
        letterSpacing = 0.2.sp,
        fontWeight = FontWeight.Normal
    ),
    bodySmall = TextStyle(
        fontFamily = spoqaHanSansNeoFontFamily,
        lineHeight = 16.0.sp,
        fontSize = 12.sp,
        letterSpacing = 0.4.sp,
        fontWeight = FontWeight.Normal
    ),
    labelLarge = TextStyle(
        fontFamily = spoqaHanSansNeoFontFamily,
        lineHeight = 20.0.sp,
        fontSize = 14.sp,
        letterSpacing = 0.1.sp,
        fontWeight = FontWeight.Medium
    ),
    labelMedium = TextStyle(
        fontFamily = spoqaHanSansNeoFontFamily,
        lineHeight = 16.0.sp,
        fontSize = 12.sp,
        letterSpacing = 0.5.sp,
        fontWeight = FontWeight.Medium
    ),
    labelSmall = TextStyle(
        fontFamily = spoqaHanSansNeoFontFamily,
        lineHeight = 16.0.sp,
        fontSize = 11.sp,
        letterSpacing = 0.5.sp,
        fontWeight = FontWeight.Medium
    ),
)
