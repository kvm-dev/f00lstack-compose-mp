package ru.kvmsoft.base.ui.icons.achievements

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush.Companion.linearGradient
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview
import ru.kvmsoft.base.ui.icons.mainIcon

public val Overachiever: ImageVector
    get() {
        if (_overachiever != null) {
            return _overachiever!!
        }
        _overachiever = Builder(name = "Overachiever", defaultWidth = 160.0.dp, defaultHeight =
                141.0.dp, viewportWidth = 160.0f, viewportHeight = 141.0f).apply {
            path(fill = SolidColor(Color(0xFF0EC1A9)), stroke = SolidColor(Color(0xFFF1F1F5)),
                    fillAlpha = 0.26f, strokeLineWidth = 1.0f, strokeLineCap = Butt, strokeLineJoin
                    = Miter, strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(16.0f, 0.5f)
                lineTo(144.0f, 0.5f)
                arcTo(15.5f, 15.5f, 0.0f, false, true, 159.5f, 16.0f)
                lineTo(159.5f, 125.0f)
                arcTo(15.5f, 15.5f, 0.0f, false, true, 144.0f, 140.5f)
                lineTo(16.0f, 140.5f)
                arcTo(15.5f, 15.5f, 0.0f, false, true, 0.5f, 125.0f)
                lineTo(0.5f, 16.0f)
                arcTo(15.5f, 15.5f, 0.0f, false, true, 16.0f, 0.5f)
                close()
            }
            path(fill = linearGradient(0.0f to Color(0xFF2AF598), 1.0f to Color(0xFF08AEEA), start =
                    Offset(80.0f,20.0f), end = Offset(80.0f,84.0f)), stroke = null, strokeLineWidth
                    = 0.0f, strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(66.0f, 20.0f)
                lineTo(94.0f, 20.0f)
                arcTo(18.0f, 18.0f, 0.0f, false, true, 112.0f, 38.0f)
                lineTo(112.0f, 66.0f)
                arcTo(18.0f, 18.0f, 0.0f, false, true, 94.0f, 84.0f)
                lineTo(66.0f, 84.0f)
                arcTo(18.0f, 18.0f, 0.0f, false, true, 48.0f, 66.0f)
                lineTo(48.0f, 38.0f)
                arcTo(18.0f, 18.0f, 0.0f, false, true, 66.0f, 20.0f)
                close()
            }
            path(fill = SolidColor(Color(0xFFffffff)), stroke = null, fillAlpha = 0.2f,
                    strokeLineWidth = 0.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(65.691f, 23.692f)
                lineTo(94.307f, 23.692f)
                arcTo(14.0f, 14.0f, 0.0f, false, true, 108.307f, 37.692f)
                lineTo(108.307f, 66.307f)
                arcTo(14.0f, 14.0f, 0.0f, false, true, 94.307f, 80.307f)
                lineTo(65.691f, 80.307f)
                arcTo(14.0f, 14.0f, 0.0f, false, true, 51.691f, 66.307f)
                lineTo(51.691f, 37.692f)
                arcTo(14.0f, 14.0f, 0.0f, false, true, 65.691f, 23.692f)
                close()
            }
            path(fill = SolidColor(Color(0xFFffffff)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(90.458f, 35.021f)
                curveTo(90.233f, 34.89f, 89.954f, 34.89f, 89.729f, 35.021f)
                curveTo(88.856f, 35.505f, 87.873f, 35.756f, 86.875f, 35.75f)
                curveTo(85.415f, 35.782f, 84.004f, 35.227f, 82.958f, 34.208f)
                curveTo(81.751f, 33.027f, 80.118f, 32.381f, 78.429f, 32.417f)
                curveTo(77.069f, 32.405f, 75.739f, 32.819f, 74.625f, 33.6f)
                verticalLineTo(33.25f)
                curveTo(74.625f, 32.56f, 74.065f, 32.0f, 73.375f, 32.0f)
                curveTo(72.685f, 32.0f, 72.125f, 32.56f, 72.125f, 33.25f)
                verticalLineTo(55.75f)
                curveTo(72.125f, 56.44f, 72.685f, 57.0f, 73.375f, 57.0f)
                curveTo(74.065f, 57.0f, 74.625f, 56.44f, 74.625f, 55.75f)
                verticalLineTo(44.917f)
                curveTo(74.763f, 44.904f, 74.895f, 44.852f, 75.004f, 44.767f)
                curveTo(75.995f, 44.037f, 77.198f, 43.65f, 78.429f, 43.667f)
                curveTo(79.891f, 43.633f, 81.306f, 44.189f, 82.354f, 45.208f)
                curveTo(83.559f, 46.389f, 85.189f, 47.034f, 86.875f, 47.0f)
                curveTo(88.167f, 47.015f, 89.435f, 46.645f, 90.517f, 45.938f)
                curveTo(90.748f, 45.777f, 90.883f, 45.511f, 90.875f, 45.229f)
                verticalLineTo(35.75f)
                curveTo(90.878f, 35.45f, 90.718f, 35.171f, 90.458f, 35.021f)
                close()
            }
        }
        .build()
        return _overachiever!!
    }

private var _overachiever: ImageVector? = null

@Preview
@Composable
private fun Preview(): Unit {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Overachiever, contentDescription = "")
    }
}

