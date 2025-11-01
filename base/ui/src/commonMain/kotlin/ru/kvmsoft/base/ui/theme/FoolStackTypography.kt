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

    val foolStackFontFamily = FontFamily(
        Font(resource = Res.font.Lato_Black, FontWeight.Black),
        Font(resource = Res.font.Lato_BlackItalic, FontWeight.Black, style = FontStyle.Italic),
        Font(resource = Res.font.Lato_Bold, FontWeight.Bold),
        Font(resource = Res.font.Lato_BoldItalic, FontWeight.Bold, style = FontStyle.Italic),
        Font(resource = Res.font.Lato_Italic, FontWeight.Normal, style = FontStyle.Italic),
        Font(resource = Res.font.Lato_Light, FontWeight.Light),
        Font(resource = Res.font.Lato_LightItalic, FontWeight.Light, style = FontStyle.Italic),
        Font(resource = Res.font.Lato_Regular, FontWeight.ExtraLight),
    )

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
            fontFamily = foolStackFontFamily,
            fontWeight = FontWeight.Bold,
            fontStyle = Italic,
            fontSize = 16.sp
        ),
        displayMedium = TextStyle(
            fontFamily = foolStackFontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp
        ),

        displaySmall = TextStyle(
            fontFamily = foolStackFontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp
        ),

        headlineLarge = TextStyle(
            fontFamily = foolStackFontFamily,
            fontWeight = FontWeight.Black,
            fontSize = 32.sp,
            brush = Brush.linearGradient(
                colors = listOf(MainOrangeLight, MainGreenLight)
            )
        ),
        headlineMedium = TextStyle(
            fontFamily = foolStackFontFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        ),

        headlineSmall = TextStyle(
            fontFamily = foolStackFontFamily,
            fontWeight = FontWeight.SemiBold,
            fontSize = 14.sp
        ),
        titleLarge = TextStyle(
            fontFamily = foolStackFontFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 48.sp
        ),
        titleMedium = TextStyle(
            fontFamily = foolStackFontFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        ),
        titleSmall = TextStyle(
            fontFamily = foolStackFontFamily,
            fontWeight = FontWeight.SemiBold,
            fontSize = 24.sp
        ),
        bodyLarge = TextStyle(
            fontFamily = foolStackFontFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 32.sp
        ),
        bodyMedium = TextStyle(
            fontFamily = foolStackFontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp
        ),
        bodySmall = TextStyle(
            fontFamily = foolStackFontFamily,
            fontWeight = FontWeight.ExtraLight,
            fontSize = 16.sp
        ),
        labelLarge = TextStyle(
            fontFamily = foolStackFontFamily,
            fontWeight = FontWeight.SemiBold,
            fontSize = 22.sp
        ),
        labelMedium = TextStyle(
            fontFamily = foolStackFontFamily,
            fontWeight = FontWeight.SemiBold,
            fontSize = 16.sp
        ),
        labelSmall = TextStyle(
            fontFamily = foolStackFontFamily,
            fontWeight = FontWeight.SemiBold,
            fontSize = 14.sp
        ),
    )
    return foolStackTypography
}
