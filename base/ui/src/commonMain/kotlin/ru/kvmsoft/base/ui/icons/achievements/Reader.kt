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

public val Reader: ImageVector
    get() {
        if (_reader != null) {
            return _reader!!
        }
        _reader = Builder(name = "Reader", defaultWidth = 160.0.dp, defaultHeight = 141.0.dp,
                viewportWidth = 160.0f, viewportHeight = 141.0f).apply {
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
            path(fill = linearGradient(0.0f to Color(0xFFFFBC47), 1.0f to Color(0xFFF49939), start =
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
                moveTo(91.107f, 34.0f)
                horizontalLineTo(84.723f)
                curveTo(83.353f, 34.0f, 82.014f, 34.502f, 80.862f, 35.448f)
                lineTo(79.5f, 36.562f)
                lineTo(78.138f, 35.448f)
                curveTo(76.987f, 34.502f, 75.646f, 33.999f, 74.277f, 34.0f)
                horizontalLineTo(67.893f)
                curveTo(67.399f, 34.0f, 67.0f, 34.509f, 67.0f, 35.139f)
                verticalLineTo(55.349f)
                curveTo(67.0f, 55.979f, 67.399f, 56.488f, 67.893f, 56.488f)
                horizontalLineTo(74.277f)
                curveTo(75.647f, 56.488f, 76.986f, 56.99f, 78.138f, 57.936f)
                lineTo(79.377f, 58.954f)
                curveTo(79.413f, 58.982f, 79.455f, 59.0f, 79.497f, 59.0f)
                curveTo(79.539f, 59.0f, 79.581f, 58.986f, 79.617f, 58.954f)
                lineTo(80.856f, 57.936f)
                curveTo(82.011f, 56.99f, 83.353f, 56.488f, 84.723f, 56.488f)
                horizontalLineTo(91.107f)
                curveTo(91.601f, 56.488f, 92.0f, 55.979f, 92.0f, 55.349f)
                verticalLineTo(35.139f)
                curveTo(92.0f, 34.509f, 91.601f, 34.0f, 91.107f, 34.0f)
                close()
                moveTo(76.487f, 47.966f)
                curveTo(76.487f, 48.112f, 76.397f, 48.233f, 76.288f, 48.233f)
                horizontalLineTo(71.104f)
                curveTo(70.995f, 48.233f, 70.906f, 48.112f, 70.906f, 47.966f)
                verticalLineTo(46.365f)
                curveTo(70.906f, 46.219f, 70.995f, 46.098f, 71.104f, 46.098f)
                horizontalLineTo(76.286f)
                curveTo(76.395f, 46.098f, 76.484f, 46.219f, 76.484f, 46.365f)
                verticalLineTo(47.966f)
                horizontalLineTo(76.487f)
                close()
                moveTo(76.487f, 42.985f)
                curveTo(76.487f, 43.13f, 76.397f, 43.251f, 76.288f, 43.251f)
                horizontalLineTo(71.104f)
                curveTo(70.995f, 43.251f, 70.906f, 43.13f, 70.906f, 42.985f)
                verticalLineTo(41.383f)
                curveTo(70.906f, 41.237f, 70.995f, 41.116f, 71.104f, 41.116f)
                horizontalLineTo(76.286f)
                curveTo(76.395f, 41.116f, 76.484f, 41.237f, 76.484f, 41.383f)
                verticalLineTo(42.985f)
                horizontalLineTo(76.487f)
                close()
                moveTo(88.094f, 47.966f)
                curveTo(88.094f, 48.112f, 88.005f, 48.233f, 87.896f, 48.233f)
                horizontalLineTo(82.712f)
                curveTo(82.603f, 48.233f, 82.513f, 48.112f, 82.513f, 47.966f)
                verticalLineTo(46.365f)
                curveTo(82.513f, 46.219f, 82.603f, 46.098f, 82.712f, 46.098f)
                horizontalLineTo(87.893f)
                curveTo(88.002f, 46.098f, 88.091f, 46.219f, 88.091f, 46.365f)
                verticalLineTo(47.966f)
                horizontalLineTo(88.094f)
                close()
                moveTo(88.094f, 42.985f)
                curveTo(88.094f, 43.13f, 88.005f, 43.251f, 87.896f, 43.251f)
                horizontalLineTo(82.712f)
                curveTo(82.603f, 43.251f, 82.513f, 43.13f, 82.513f, 42.985f)
                verticalLineTo(41.383f)
                curveTo(82.513f, 41.237f, 82.603f, 41.116f, 82.712f, 41.116f)
                horizontalLineTo(87.893f)
                curveTo(88.002f, 41.116f, 88.091f, 41.237f, 88.091f, 41.383f)
                verticalLineTo(42.985f)
                horizontalLineTo(88.094f)
                close()
            }
        }
        .build()
        return _reader!!
    }

private var _reader: ImageVector? = null

@Preview
@Composable
private fun Preview(): Unit {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Reader, contentDescription = "")
    }
}

