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

public val Eternalstudent: ImageVector
    get() {
        if (_eternalstudent != null) {
            return _eternalstudent!!
        }
        _eternalstudent = Builder(name = "Eternalstudent", defaultWidth = 160.0.dp, defaultHeight =
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
            path(fill = linearGradient(0.0f to Color(0xFF73A5FF), 1.0f to Color(0xFF345DED), start =
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
                moveTo(91.915f, 57.09f)
                curveTo(92.124f, 57.09f, 92.323f, 56.99f, 92.455f, 56.817f)
                curveTo(92.587f, 56.644f, 92.638f, 56.417f, 92.595f, 56.199f)
                lineTo(92.157f, 53.998f)
                curveTo(92.407f, 53.742f, 92.563f, 53.384f, 92.563f, 52.986f)
                curveTo(92.563f, 52.568f, 92.388f, 52.196f, 92.115f, 51.938f)
                verticalLineTo(44.296f)
                lineTo(90.359f, 45.45f)
                verticalLineTo(51.938f)
                curveTo(90.087f, 52.196f, 89.911f, 52.568f, 89.911f, 52.986f)
                curveTo(89.911f, 53.384f, 90.068f, 53.742f, 90.317f, 53.998f)
                lineTo(89.879f, 56.199f)
                curveTo(89.836f, 56.417f, 89.888f, 56.644f, 90.02f, 56.817f)
                curveTo(90.152f, 56.99f, 90.35f, 57.09f, 90.56f, 57.09f)
                horizontalLineTo(91.915f)
                close()
                moveTo(92.51f, 39.836f)
                lineTo(81.088f, 32.329f)
                curveTo(80.753f, 32.11f, 80.376f, 32.0f, 79.999f, 32.0f)
                curveTo(79.622f, 32.0f, 79.245f, 32.11f, 78.912f, 32.329f)
                lineTo(67.49f, 39.836f)
                curveTo(67.185f, 40.036f, 67.0f, 40.39f, 67.0f, 40.771f)
                curveTo(67.0f, 41.152f, 67.185f, 41.506f, 67.49f, 41.707f)
                lineTo(78.912f, 49.215f)
                curveTo(79.245f, 49.434f, 79.622f, 49.543f, 79.999f, 49.543f)
                curveTo(80.376f, 49.543f, 80.753f, 49.433f, 81.088f, 49.215f)
                lineTo(92.51f, 41.707f)
                curveTo(92.815f, 41.506f, 93.0f, 41.152f, 93.0f, 40.771f)
                curveTo(93.0f, 40.39f, 92.815f, 40.036f, 92.51f, 39.836f)
                close()
                moveTo(79.999f, 51.407f)
                curveTo(79.288f, 51.407f, 78.593f, 51.197f, 77.988f, 50.8f)
                lineTo(71.326f, 46.42f)
                verticalLineTo(53.961f)
                curveTo(71.326f, 56.193f, 75.211f, 58.0f, 79.999f, 58.0f)
                curveTo(84.789f, 58.0f, 88.674f, 56.193f, 88.674f, 53.961f)
                verticalLineTo(46.42f)
                lineTo(82.012f, 50.8f)
                curveTo(81.407f, 51.197f, 80.711f, 51.407f, 79.999f, 51.407f)
                close()
            }
        }
        .build()
        return _eternalstudent!!
    }

private var _eternalstudent: ImageVector? = null

@Preview
@Composable
private fun Preview(): Unit {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Eternalstudent, contentDescription = "")
    }
}
