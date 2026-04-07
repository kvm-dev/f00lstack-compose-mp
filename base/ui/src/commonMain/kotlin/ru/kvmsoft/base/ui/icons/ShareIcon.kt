package ru.kvmsoft.base.ui.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val ShareIcon: ImageVector
    get() {
        if (_shareicon != null) {
            return _shareicon!!
        }
        _shareicon = Builder(name = "Shareicon", defaultWidth = 27.0.dp, defaultHeight = 32.0.dp,
                viewportWidth = 27.0f, viewportHeight = 32.0f).apply {
            path(fill = SolidColor(Color(0xFFffffff)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(11.3333f, 6.4f)
                curveTo(11.7015f, 6.4f, 12.0f, 6.7582f, 12.0f, 7.2f)
                curveTo(12.0f, 7.5927f, 11.7642f, 7.9194f, 11.4532f, 7.9871f)
                lineTo(11.3333f, 8.0f)
                horizontalLineTo(7.3333f)
                curveTo(6.2937f, 8.0f, 5.4394f, 8.9518f, 5.3425f, 10.1689f)
                lineTo(5.3333f, 10.4f)
                verticalLineTo(23.2f)
                curveTo(5.3333f, 24.4475f, 6.1265f, 25.4727f, 7.1407f, 25.589f)
                lineTo(7.3333f, 25.6f)
                horizontalLineTo(18.0f)
                curveTo(19.0396f, 25.6f, 19.8939f, 24.6481f, 19.9908f, 23.4311f)
                lineTo(20.0f, 23.2f)
                verticalLineTo(21.6f)
                curveTo(20.0f, 21.1582f, 20.2985f, 20.8f, 20.6667f, 20.8f)
                curveTo(20.9939f, 20.8f, 21.2661f, 21.083f, 21.3226f, 21.4562f)
                lineTo(21.3333f, 21.6f)
                verticalLineTo(23.2f)
                curveTo(21.3333f, 25.3207f, 19.9579f, 27.056f, 18.2192f, 27.1915f)
                lineTo(18.0f, 27.2f)
                horizontalLineTo(7.3333f)
                curveTo(5.566f, 27.2f, 4.1199f, 25.5495f, 4.0071f, 23.463f)
                lineTo(4.0f, 23.2f)
                verticalLineTo(10.4f)
                curveTo(4.0f, 8.2792f, 5.3754f, 6.5439f, 7.1142f, 6.4085f)
                lineTo(7.3333f, 6.4f)
                horizontalLineTo(11.3333f)
                close()
                moveTo(16.5035f, 5.7245f)
                curveTo(16.5035f, 5.008f, 17.1193f, 4.6001f, 17.5919f, 4.8988f)
                lineTo(17.6907f, 4.9738f)
                lineTo(17.7729f, 5.0586f)
                lineTo(23.7691f, 12.1325f)
                curveTo(24.0178f, 12.426f, 24.0656f, 12.8776f, 23.9124f, 13.2317f)
                lineTo(23.8455f, 13.3595f)
                lineTo(23.7692f, 13.4642f)
                lineTo(17.7731f, 20.5403f)
                curveTo(17.3527f, 21.0364f, 16.6869f, 20.7722f, 16.535f, 20.1458f)
                lineTo(16.5105f, 20.0062f)
                lineTo(16.5035f, 19.8745f)
                verticalLineTo(16.5218f)
                lineTo(16.1599f, 16.5589f)
                curveTo(15.828f, 16.6014f, 15.4981f, 16.6635f, 15.1701f, 16.7451f)
                curveTo(13.1251f, 17.2544f, 11.1526f, 18.5246f, 9.2435f, 20.5702f)
                curveTo(8.7242f, 21.1267f, 7.9209f, 20.6006f, 8.0063f, 19.7601f)
                curveTo(8.6546f, 13.3794f, 11.316f, 9.7909f, 15.8514f, 9.1961f)
                lineTo(16.204f, 9.1563f)
                lineTo(16.5035f, 9.1321f)
                verticalLineTo(5.7245f)
                close()
                moveTo(17.8368f, 7.3776f)
                verticalLineTo(10.6281f)
                lineTo(16.3017f, 10.752f)
                curveTo(14.2035f, 10.9537f, 12.6565f, 11.8308f, 11.5509f, 13.2616f)
                curveTo(10.6589f, 14.4161f, 9.9799f, 16.0278f, 9.5823f, 18.1688f)
                curveTo(11.4697f, 16.4715f, 13.4631f, 15.4078f, 15.5659f, 15.0368f)
                lineTo(16.0293f, 14.9664f)
                lineTo(17.8368f, 14.7716f)
                verticalLineTo(18.2211f)
                lineTo(22.4317f, 12.7985f)
                lineTo(17.8368f, 7.3776f)
                close()
            }
        }
        .build()
        return _shareicon!!
    }

private var _shareicon: ImageVector? = null
