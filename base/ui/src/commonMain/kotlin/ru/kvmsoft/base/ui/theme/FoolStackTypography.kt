package ru.kvmsoft.base.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontStyle.Companion.Italic
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.Font
import ru.kvmsoft.base.ui.ComposeResources.Lato_Black
import ru.kvmsoft.base.ui.ComposeResources.Lato_BlackItalic
import ru.kvmsoft.base.ui.ComposeResources.Lato_Bold
import ru.kvmsoft.base.ui.ComposeResources.Lato_BoldItalic
import ru.kvmsoft.base.ui.ComposeResources.Lato_Italic
import ru.kvmsoft.base.ui.ComposeResources.Lato_Light
import ru.kvmsoft.base.ui.ComposeResources.Lato_LightItalic
import ru.kvmsoft.base.ui.ComposeResources.Lato_Regular
import ru.kvmsoft.base.ui.ComposeResources.Res


@Composable
fun getFoolStackTypography(): Typography {

    val foolStackTypography = Typography(
//        displayLarge = TextStyle(
//            fontFamily = foolStackFontFamily,
//            fontWeight = FontWeight.Bold,
//            fontStyle = Italic,
//            fontSize = 16.sp,
//            brush = Brush.linearGradient(
//                colors = listOf(MainOrangeLight, MainGreenLight)
//            )
//        ),
        displayLarge = TextStyle(
            fontFamily = getFoolStackFontFamily(),
            fontWeight = FontWeight.Bold,
            fontStyle = Italic,
            fontSize = 16.sp
        ),
        displayMedium = TextStyle(
            fontFamily = getFoolStackFontFamily(),
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp
        ),

        displaySmall = TextStyle(
            fontFamily = getFoolStackFontFamily(),
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp
        ),

        headlineLarge = TextStyle(
            fontFamily = getFoolStackFontFamily(),
            fontWeight = FontWeight.Black,
            fontSize = 32.sp,
            brush = Brush.linearGradient(
                colors = listOf(MainOrangeLight, MainGreenLight)
            )
        ),
        headlineMedium = TextStyle(
            fontFamily = getFoolStackFontFamily(),
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        ),

        headlineSmall = TextStyle(
            fontFamily = getFoolStackFontFamily(),
            fontWeight = FontWeight.SemiBold,
            fontSize = 14.sp
        ),
        titleLarge = TextStyle(
            fontFamily = getFoolStackFontFamily(),
            fontWeight = FontWeight.Bold,
            fontSize = 48.sp
        ),
        titleMedium = TextStyle(
            fontFamily = getFoolStackFontFamily(),
            fontWeight = FontWeight.Normal,
            fontSize = 18.sp
        ),
        titleSmall = TextStyle(
            fontFamily = getFoolStackFontFamily(),
            fontWeight = FontWeight.SemiBold,
            fontSize = 24.sp
        ),
        bodyLarge = TextStyle(
            fontFamily = getFoolStackFontFamily(),
            fontWeight = FontWeight.Bold,
            fontSize = 32.sp
        ),
        bodyMedium = TextStyle(
            fontFamily = getFoolStackFontFamily(),
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp
        ),
        bodySmall = TextStyle(
            fontFamily = getFoolStackFontFamily(),
            fontWeight = FontWeight.ExtraLight,
            fontSize = 16.sp
        ),
        labelLarge = TextStyle(
            fontFamily = getFoolStackFontFamily(),
            fontWeight = FontWeight.SemiBold,
            fontSize = 22.sp
        ),
        labelMedium = TextStyle(
            fontFamily = getFoolStackFontFamily(),
            fontWeight = FontWeight.SemiBold,
            fontSize = 16.sp
        ),
        labelSmall = TextStyle(
            fontFamily = getFoolStackFontFamily(),
            fontWeight = FontWeight.Black,
            fontSize = 14.sp
        ),
    )
    return foolStackTypography
}
