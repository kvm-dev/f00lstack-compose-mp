package ru.kvmsoft.base.ui.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Round
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val BackArrowIcon: ImageVector
    get() {
        if (_backArrowIcon != null) {
            return _backArrowIcon!!
        }
        _backArrowIcon = Builder(name = "BackArrowIcon", defaultWidth = 8.0.dp, defaultHeight =
            14.0.dp, viewportWidth = 8.0f, viewportHeight = 14.0f).apply {
            path(fill = SolidColor(Color(0x00000000)), stroke = SolidColor(Color(0xFFFC5B31)),
                strokeLineWidth = 2.0f, strokeLineCap = Round, strokeLineJoin =
                    StrokeJoin.Round, strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(7.0f, 13.0f)
                lineTo(1.0f, 7.0f)
                lineTo(7.0f, 1.0f)
            }
        }
            .build()
        return _backArrowIcon!!
    }

private var _backArrowIcon: ImageVector? = null
