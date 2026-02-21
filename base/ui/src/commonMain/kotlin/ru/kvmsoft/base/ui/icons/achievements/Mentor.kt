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
import androidx.compose.ui.graphics.StrokeCap.Companion.Round
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.group
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview
import ru.kvmsoft.base.ui.icons.mainIcon

public val Mentor: ImageVector
    get() {
        if (_mentor != null) {
            return _mentor!!
        }
        _mentor = Builder(name = "Mentor", defaultWidth = 160.0.dp, defaultHeight = 141.0.dp,
                viewportWidth = 160.0f, viewportHeight = 141.0f).apply {
            path(fill = SolidColor(Color(0xFF0EC1A9)), stroke = SolidColor(Color(0xFFF1F1F5)),
                    fillAlpha = 0.26f, strokeLineWidth = 1.0f, strokeLineCap = Butt, strokeLineJoin
                    = Miter, strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(18.56f, 0.5f)
                horizontalLineTo(141.44f)
                curveTo(143.833f, 0.5f, 144.983f, 0.501f, 145.942f, 0.622f)
                curveTo(152.962f, 1.509f, 158.491f, 7.038f, 159.378f, 14.058f)
                curveTo(159.499f, 15.017f, 159.5f, 16.167f, 159.5f, 18.56f)
                verticalLineTo(122.44f)
                curveTo(159.5f, 124.833f, 159.499f, 125.983f, 159.378f, 126.942f)
                curveTo(158.491f, 133.962f, 152.962f, 139.491f, 145.942f, 140.378f)
                curveTo(144.983f, 140.499f, 143.833f, 140.5f, 141.44f, 140.5f)
                horizontalLineTo(18.56f)
                curveTo(16.167f, 140.5f, 15.017f, 140.499f, 14.058f, 140.378f)
                curveTo(7.038f, 139.491f, 1.509f, 133.962f, 0.622f, 126.942f)
                curveTo(0.501f, 125.983f, 0.5f, 124.833f, 0.5f, 122.44f)
                verticalLineTo(18.56f)
                curveTo(0.5f, 16.167f, 0.501f, 15.017f, 0.622f, 14.058f)
                curveTo(1.509f, 7.038f, 7.038f, 1.509f, 14.058f, 0.622f)
                curveTo(15.017f, 0.501f, 16.167f, 0.5f, 18.56f, 0.5f)
                close()
            }
            path(fill = linearGradient(0.0f to Color(0xFF585867), 1.0f to Color(0xFF171725), start =
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
            group {
                path(fill = SolidColor(Color(0x00000000)), stroke = SolidColor(Color(0xFFffffff)),
                        strokeLineWidth = 1.5f, strokeLineCap = Round, strokeLineJoin =
                        StrokeJoin.Companion.Round, strokeLineMiter = 4.0f, pathFillType =
                        NonZero) {
                    moveTo(92.489f, 52.185f)
                    lineTo(94.084f, 40.159f)
                    curveTo(94.108f, 39.995f, 94.087f, 39.828f, 94.023f, 39.675f)
                    curveTo(93.958f, 39.522f, 93.853f, 39.39f, 93.719f, 39.293f)
                    curveTo(93.585f, 39.195f, 93.426f, 39.137f, 93.261f, 39.124f)
                    curveTo(93.096f, 39.11f, 92.93f, 39.142f, 92.782f, 39.217f)
                    lineTo(87.609f, 43.155f)
                    curveTo(87.511f, 43.234f, 87.398f, 43.292f, 87.277f, 43.325f)
                    curveTo(87.156f, 43.359f, 87.03f, 43.367f, 86.906f, 43.349f)
                    curveTo(86.781f, 43.331f, 86.662f, 43.287f, 86.556f, 43.221f)
                    curveTo(86.449f, 43.154f, 86.358f, 43.066f, 86.287f, 42.963f)
                    lineTo(81.182f, 35.495f)
                    curveTo(81.097f, 35.398f, 80.992f, 35.32f, 80.874f, 35.266f)
                    curveTo(80.757f, 35.213f, 80.629f, 35.185f, 80.5f, 35.185f)
                    curveTo(80.371f, 35.185f, 80.243f, 35.213f, 80.126f, 35.266f)
                    curveTo(80.008f, 35.32f, 79.903f, 35.398f, 79.818f, 35.495f)
                    lineTo(74.713f, 42.963f)
                    curveTo(74.642f, 43.066f, 74.551f, 43.154f, 74.444f, 43.22f)
                    curveTo(74.337f, 43.286f, 74.218f, 43.329f, 74.094f, 43.347f)
                    curveTo(73.97f, 43.365f, 73.843f, 43.357f, 73.722f, 43.324f)
                    curveTo(73.601f, 43.29f, 73.489f, 43.232f, 73.391f, 43.152f)
                    lineTo(68.218f, 39.217f)
                    curveTo(68.07f, 39.142f, 67.905f, 39.11f, 67.739f, 39.124f)
                    curveTo(67.574f, 39.137f, 67.416f, 39.195f, 67.281f, 39.293f)
                    curveTo(67.147f, 39.39f, 67.042f, 39.522f, 66.977f, 39.675f)
                    curveTo(66.913f, 39.828f, 66.892f, 39.995f, 66.916f, 40.159f)
                    lineTo(68.511f, 52.185f)
                    horizontalLineTo(92.489f)
                    close()
                }
                path(fill = SolidColor(Color(0x00000000)), stroke = SolidColor(Color(0xFFffffff)),
                        strokeLineWidth = 1.5f, strokeLineCap = Round, strokeLineJoin =
                        StrokeJoin.Companion.Round, strokeLineMiter = 4.0f, pathFillType =
                        NonZero) {
                    moveTo(68.719f, 55.81f)
                    horizontalLineTo(92.281f)
                }
            }
        }
        .build()
        return _mentor!!
    }

private var _mentor: ImageVector? = null

@Preview
@Composable
private fun Preview(): Unit {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Mentor, contentDescription = "")
    }
}

