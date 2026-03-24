package ru.kvmsoft.base.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontStyle.Companion.Italic
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

object TextStyles {
    @Composable
    fun getTitlesStyle() = getFoolStackTypography()

    @Composable
    fun serviceTagStyle() = TextStyle(
        fontFamily = getFoolStackFontFamily(),
        fontWeight = FontWeight.Bold,
        fontSize = 12.sp,
        color = SimplyWhite,
        textAlign = TextAlign.Center
    )

    @Composable
    fun serviceTextStyle() = TextStyle(
        fontFamily = getFoolStackFontFamily(),
        fontWeight = FontWeight.Bold,
        fontSize = 10.sp,
        color = SimplyWhite,
        textAlign = TextAlign.Start
    )

    @Composable
    fun serviceTitleStyle() = TextStyle(
        fontFamily = getFoolStackFontFamily(),
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp,
        color = SimplyWhite,
        textAlign = TextAlign.Center
    )

    @Composable
    fun screenTitleStyle() = TextStyle(
        fontFamily = getFoolStackFontFamily(),
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp,
        color = SimplyWhite,
        textAlign = TextAlign.Center
    )

    @Composable
    fun chipsStyle() = TextStyle(
        fontFamily = getFoolStackFontFamily(),
        fontWeight = FontWeight.Black,
        fontSize = 14.sp,
        color = SimplyBlack,
        fontStyle = Italic,
        textAlign = TextAlign.Center
    )

    @Composable
    fun bottomSheetButtonStyle() = TextStyle(
        fontFamily = getFoolStackFontFamily(),
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp,
        color = SimplyWhite,
        textAlign = TextAlign.Center
    )

    @Composable
    fun bottomSheetButtonBlackStyle() = TextStyle(
        fontFamily = getFoolStackFontFamily(),
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp,
        color = SimplyBlack,
        textAlign = TextAlign.Center
    )

    @Composable
    fun notificationTitleStyle() = TextStyle(
        fontFamily = getFoolStackFontFamily(),
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        color = SimplyWhite,
        textAlign = TextAlign.Center
    )

    @Composable
    fun boldItalicLabel() = TextStyle(
        fontFamily = getFoolStackFontFamily(),
        fontWeight = FontWeight.Bold,
        fontStyle = Italic,
        fontSize = 14.sp,
        color = SimplyWhite,
        textAlign = TextAlign.Center
    )

    @Composable
    fun textArea() = TextStyle(
        fontFamily = getFoolStackFontFamily(),
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        color = SimplyWhite,
        textAlign = TextAlign.Start
    )
}