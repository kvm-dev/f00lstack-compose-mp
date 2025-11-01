package ru.kvmsoft.base.ui.icons

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.EvenOdd
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import org.jetbrains.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlin.Unit

public val testsIcon: ImageVector
    get() {
        if (_tests != null) {
            return _tests!!
        }
        _tests = Builder(name = "Tests", defaultWidth = 24.0.dp, defaultHeight = 24.0.dp,
                viewportWidth = 24.0f, viewportHeight = 24.0f).apply {
            path(fill = SolidColor(Color(0xFFCDD2DF)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = EvenOdd) {
                moveTo(19.302f, 10.221f)
                curveTo(19.721f, 10.221f, 20.074f, 10.018f, 20.074f, 9.761f)
                curveTo(20.074f, 9.512f, 19.732f, 9.302f, 19.302f, 9.302f)
                horizontalLineTo(10.975f)
                curveTo(10.54f, 9.302f, 10.203f, 9.512f, 10.203f, 9.761f)
                curveTo(10.203f, 10.02f, 10.556f, 10.221f, 10.975f, 10.221f)
                horizontalLineTo(19.302f)
                close()
                moveTo(6.973f, 15.012f)
                curveTo(7.488f, 15.012f, 7.912f, 15.215f, 7.912f, 15.534f)
                verticalLineTo(18.97f)
                horizontalLineTo(8.48f)
                verticalLineTo(17.332f)
                curveTo(8.48f, 16.67f, 10.234f, 16.691f, 10.234f, 17.369f)
                verticalLineTo(19.007f)
                lineTo(10.262f, 19.001f)
                horizontalLineTo(10.877f)
                verticalLineTo(17.7f)
                curveTo(10.877f, 17.038f, 12.631f, 17.058f, 12.631f, 17.737f)
                verticalLineTo(18.946f)
                lineTo(12.638f, 18.947f)
                lineTo(13.249f, 18.945f)
                verticalLineTo(18.023f)
                curveTo(13.249f, 17.362f, 15.003f, 17.382f, 15.003f, 18.06f)
                curveTo(15.003f, 18.823f, 15.076f, 19.725f, 15.03f, 20.488f)
                curveTo(14.978f, 21.324f, 14.689f, 22.266f, 13.669f, 22.795f)
                curveTo(12.375f, 23.42f, 11.081f, 23.585f, 9.738f, 23.459f)
                curveTo(7.324f, 23.232f, 6.712f, 22.35f, 5.565f, 21.267f)
                lineTo(2.649f, 18.514f)
                curveTo(2.47f, 18.263f, 2.494f, 18.093f, 2.674f, 17.984f)
                curveTo(3.449f, 17.685f, 4.71f, 18.321f, 6.108f, 19.22f)
                lineTo(6.158f, 19.213f)
                verticalLineTo(15.497f)
                curveTo(6.158f, 15.23f, 6.524f, 15.012f, 6.973f, 15.012f)
                close()
                moveTo(4.552f, 0.0f)
                horizontalLineTo(19.448f)
                curveTo(20.704f, 0.0f, 21.85f, 0.305f, 22.667f, 0.795f)
                curveTo(23.495f, 1.288f, 24.0f, 1.967f, 24.0f, 2.711f)
                verticalLineTo(21.29f)
                curveTo(24.0f, 22.038f, 23.489f, 22.72f, 22.667f, 23.206f)
                curveTo(21.837f, 23.7f, 20.698f, 24.0f, 19.448f, 24.0f)
                horizontalLineTo(12.334f)
                curveTo(13.001f, 23.868f, 13.659f, 23.655f, 14.311f, 23.347f)
                lineTo(14.41f, 23.301f)
                curveTo(15.08f, 22.954f, 15.508f, 22.491f, 15.774f, 21.985f)
                lineTo(15.793f, 21.951f)
                curveTo(16.028f, 21.487f, 16.125f, 20.983f, 16.154f, 20.511f)
                curveTo(16.16f, 20.421f, 16.164f, 20.329f, 16.166f, 20.235f)
                horizontalLineTo(22.544f)
                verticalLineTo(2.685f)
                horizontalLineTo(1.45f)
                verticalLineTo(17.959f)
                curveTo(1.422f, 18.028f, 1.406f, 18.099f, 1.402f, 18.169f)
                curveTo(1.395f, 18.267f, 1.41f, 18.37f, 1.45f, 18.478f)
                verticalLineTo(20.235f)
                horizontalLineTo(3.142f)
                lineTo(4.612f, 21.624f)
                lineTo(4.99f, 21.989f)
                curveTo(5.935f, 22.913f, 6.701f, 23.66f, 8.649f, 24.0f)
                horizontalLineTo(4.552f)
                curveTo(3.296f, 24.0f, 2.15f, 23.696f, 1.334f, 23.206f)
                curveTo(0.505f, 22.713f, 0.0f, 22.034f, 0.0f, 21.29f)
                verticalLineTo(2.707f)
                curveTo(0.0f, 1.959f, 0.511f, 1.277f, 1.334f, 0.791f)
                curveTo(2.162f, 0.297f, 3.296f, 0.0f, 4.552f, 0.0f)
                close()
                moveTo(4.221f, 12.748f)
                horizontalLineTo(8.043f)
                curveTo(8.182f, 12.748f, 8.315f, 12.781f, 8.414f, 12.84f)
                curveTo(8.512f, 12.898f, 8.568f, 12.977f, 8.568f, 13.06f)
                verticalLineTo(14.766f)
                curveTo(8.52f, 14.733f, 8.47f, 14.702f, 8.417f, 14.672f)
                curveTo(8.165f, 14.532f, 7.856f, 14.432f, 7.518f, 14.38f)
                verticalLineTo(13.373f)
                horizontalLineTo(4.745f)
                verticalLineTo(14.983f)
                horizontalLineTo(5.231f)
                curveTo(5.097f, 15.142f, 5.028f, 15.319f, 5.028f, 15.497f)
                verticalLineTo(15.607f)
                horizontalLineTo(4.221f)
                curveTo(4.082f, 15.607f, 3.948f, 15.574f, 3.85f, 15.516f)
                curveTo(3.751f, 15.457f, 3.696f, 15.378f, 3.696f, 15.295f)
                verticalLineTo(13.06f)
                curveTo(3.696f, 12.977f, 3.751f, 12.898f, 3.85f, 12.84f)
                curveTo(3.948f, 12.781f, 4.082f, 12.748f, 4.221f, 12.748f)
                close()
                moveTo(19.302f, 14.637f)
                curveTo(19.721f, 14.637f, 20.074f, 14.434f, 20.074f, 14.177f)
                curveTo(20.074f, 13.928f, 19.732f, 13.718f, 19.302f, 13.718f)
                horizontalLineTo(10.975f)
                curveTo(10.54f, 13.718f, 10.203f, 13.928f, 10.203f, 14.177f)
                curveTo(10.203f, 14.436f, 10.556f, 14.637f, 10.975f, 14.637f)
                horizontalLineTo(19.302f)
                close()
                moveTo(3.89f, 5.806f)
                curveTo(3.634f, 5.626f, 3.672f, 5.356f, 3.974f, 5.204f)
                curveTo(4.277f, 5.052f, 4.73f, 5.074f, 4.985f, 5.254f)
                lineTo(5.626f, 5.705f)
                lineTo(7.265f, 4.483f)
                curveTo(7.511f, 4.299f, 7.964f, 4.268f, 8.273f, 4.415f)
                curveTo(8.583f, 4.562f, 8.635f, 4.831f, 8.388f, 5.015f)
                lineTo(6.203f, 6.644f)
                lineTo(6.105f, 6.704f)
                curveTo(5.803f, 6.856f, 5.349f, 6.834f, 5.094f, 6.654f)
                lineTo(3.89f, 5.806f)
                close()
                moveTo(19.302f, 6.005f)
                curveTo(19.721f, 6.005f, 20.074f, 5.802f, 20.074f, 5.545f)
                curveTo(20.074f, 5.296f, 19.732f, 5.086f, 19.302f, 5.086f)
                horizontalLineTo(10.975f)
                curveTo(10.54f, 5.086f, 10.203f, 5.296f, 10.203f, 5.545f)
                curveTo(10.203f, 5.804f, 10.556f, 6.005f, 10.975f, 6.005f)
                horizontalLineTo(19.302f)
                close()
                moveTo(4.221f, 8.332f)
                horizontalLineTo(8.043f)
                curveTo(8.182f, 8.332f, 8.315f, 8.365f, 8.414f, 8.423f)
                curveTo(8.512f, 8.482f, 8.568f, 8.561f, 8.568f, 8.644f)
                verticalLineTo(10.879f)
                curveTo(8.568f, 10.962f, 8.512f, 11.041f, 8.414f, 11.099f)
                curveTo(8.315f, 11.158f, 8.182f, 11.191f, 8.043f, 11.191f)
                horizontalLineTo(4.221f)
                curveTo(4.082f, 11.191f, 3.948f, 11.158f, 3.85f, 11.099f)
                curveTo(3.751f, 11.041f, 3.696f, 10.962f, 3.696f, 10.879f)
                verticalLineTo(8.644f)
                curveTo(3.696f, 8.561f, 3.751f, 8.482f, 3.85f, 8.423f)
                curveTo(3.948f, 8.365f, 4.082f, 8.332f, 4.221f, 8.332f)
                close()
                moveTo(7.518f, 8.956f)
                horizontalLineTo(4.745f)
                verticalLineTo(10.566f)
                horizontalLineTo(7.518f)
                verticalLineTo(8.956f)
                close()
            }
        }
        .build()
        return _tests!!
    }

private var _tests: ImageVector? = null

@Preview
@Composable
private fun Preview(): Unit {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = testsIcon, contentDescription = "")
    }
}
