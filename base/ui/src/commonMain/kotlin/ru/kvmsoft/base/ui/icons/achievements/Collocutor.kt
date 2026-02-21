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
import androidx.compose.ui.graphics.vector.group
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview

public val Collocutor: ImageVector
    get() {
        if (_collocutor != null) {
            return _collocutor!!
        }
        _collocutor = Builder(name = "Collocutor", defaultWidth = 160.0.dp, defaultHeight =
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
            path(fill = linearGradient(0.0f to Color(0xFFFFE53B), 1.0f to Color(0xFFFF2525), start =
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
                path(fill = SolidColor(Color(0xFFffffff)), stroke = null, strokeLineWidth = 0.0f,
                        strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                        pathFillType = NonZero) {
                    moveTo(92.937f, 40.205f)
                    curveTo(92.779f, 39.719f, 92.348f, 39.375f, 91.84f, 39.329f)
                    lineTo(84.912f, 38.7f)
                    lineTo(82.174f, 32.29f)
                    curveTo(81.972f, 31.819f, 81.512f, 31.515f, 81.0f, 31.515f)
                    curveTo(80.488f, 31.515f, 80.028f, 31.819f, 79.827f, 32.29f)
                    lineTo(77.089f, 38.7f)
                    lineTo(70.16f, 39.329f)
                    curveTo(69.652f, 39.376f, 69.222f, 39.72f, 69.063f, 40.205f)
                    curveTo(68.905f, 40.691f, 69.051f, 41.224f, 69.435f, 41.561f)
                    lineTo(74.672f, 46.153f)
                    lineTo(73.128f, 52.954f)
                    curveTo(73.015f, 53.454f, 73.209f, 53.972f, 73.624f, 54.271f)
                    curveTo(73.847f, 54.433f, 74.109f, 54.514f, 74.372f, 54.514f)
                    curveTo(74.598f, 54.514f, 74.824f, 54.454f, 75.026f, 54.333f)
                    lineTo(81.0f, 50.761f)
                    lineTo(86.973f, 54.333f)
                    curveTo(87.411f, 54.595f, 87.962f, 54.571f, 88.376f, 54.271f)
                    curveTo(88.791f, 53.972f, 88.985f, 53.454f, 88.872f, 52.954f)
                    lineTo(87.328f, 46.153f)
                    lineTo(92.565f, 41.561f)
                    curveTo(92.949f, 41.224f, 93.095f, 40.692f, 92.937f, 40.205f)
                    close()
                }
            }
        }
        .build()
        return _collocutor!!
    }

private var _collocutor: ImageVector? = null

@Preview
@Composable
private fun Preview(): Unit {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Collocutor, contentDescription = "")
    }
}

