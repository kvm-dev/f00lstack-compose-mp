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

public val Ideagenerator: ImageVector
    get() {
        if (_ideagenerator != null) {
            return _ideagenerator!!
        }
        _ideagenerator = Builder(name = "Ideagenerator", defaultWidth = 160.0.dp, defaultHeight =
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
            path(fill = linearGradient(0.0f to Color(0xFFFF9263), 1.0f to Color(0xFFFF5A9B), start =
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
                moveTo(74.805f, 48.933f)
                curveTo(71.934f, 47.271f, 70.0f, 44.166f, 70.0f, 40.609f)
                curveTo(70.0f, 35.304f, 74.304f, 31.0f, 79.609f, 31.0f)
                curveTo(84.915f, 31.0f, 89.219f, 35.304f, 89.219f, 40.609f)
                curveTo(89.219f, 44.166f, 87.285f, 47.271f, 84.414f, 48.933f)
                verticalLineTo(52.328f)
                curveTo(84.414f, 52.847f, 83.995f, 53.266f, 83.477f, 53.266f)
                horizontalLineTo(75.742f)
                curveTo(75.224f, 53.266f, 74.805f, 52.847f, 74.805f, 52.328f)
                verticalLineTo(48.933f)
                close()
                moveTo(76.094f, 55.141f)
                horizontalLineTo(83.125f)
                curveTo(83.254f, 55.141f, 83.359f, 55.246f, 83.359f, 55.375f)
                verticalLineTo(56.313f)
                curveTo(83.359f, 56.831f, 82.94f, 57.25f, 82.422f, 57.25f)
                horizontalLineTo(76.797f)
                curveTo(76.278f, 57.25f, 75.859f, 56.831f, 75.859f, 56.313f)
                verticalLineTo(55.375f)
                curveTo(75.859f, 55.246f, 75.965f, 55.141f, 76.094f, 55.141f)
                close()
            }
        }
        .build()
        return _ideagenerator!!
    }

private var _ideagenerator: ImageVector? = null

@Preview
@Composable
private fun Preview(): Unit {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Ideagenerator, contentDescription = "")
    }
}

