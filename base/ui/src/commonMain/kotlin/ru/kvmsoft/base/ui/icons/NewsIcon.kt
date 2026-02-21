package ru.kvmsoft.base.ui.icons

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
import kotlin.Unit

public val newsIcon: ImageVector
    get() {
        if (_news != null) {
            return _news!!
        }
        _news = Builder(name = "News", defaultWidth = 25.0.dp, defaultHeight = 25.0.dp,
                viewportWidth = 25.0f, viewportHeight = 25.0f).apply {
            path(fill = SolidColor(Color(0xFFCDD2DF)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(3.221f, 0.108f)
                curveTo(1.884f, 0.108f, 0.793f, 1.361f, 0.793f, 2.896f)
                verticalLineTo(13.928f)
                verticalLineTo(14.883f)
                verticalLineTo(20.161f)
                curveTo(0.793f, 22.339f, 2.336f, 24.108f, 4.234f, 24.108f)
                horizontalLineTo(19.622f)
                horizontalLineTo(23.233f)
                curveTo(23.41f, 24.108f, 23.58f, 24.072f, 23.74f, 24.007f)
                curveTo(24.097f, 23.978f, 24.373f, 23.699f, 24.535f, 23.388f)
                curveTo(24.642f, 23.182f, 24.712f, 22.948f, 24.752f, 22.697f)
                curveTo(24.756f, 22.676f, 24.759f, 22.656f, 24.762f, 22.635f)
                curveTo(24.768f, 22.595f, 24.774f, 22.556f, 24.778f, 22.515f)
                curveTo(24.784f, 22.458f, 24.787f, 22.399f, 24.787f, 22.34f)
                curveTo(24.787f, 22.333f, 24.788f, 22.327f, 24.788f, 22.321f)
                curveTo(24.789f, 22.289f, 24.793f, 22.258f, 24.793f, 22.226f)
                verticalLineTo(9.124f)
                horizontalLineTo(24.788f)
                verticalLineTo(3.9f)
                curveTo(24.788f, 2.945f, 24.122f, 2.159f, 23.297f, 2.119f)
                curveTo(23.003f, 0.96f, 22.069f, 0.108f, 20.966f, 0.108f)
                lineTo(3.221f, 0.108f)
                close()
                moveTo(3.221f, 1.157f)
                horizontalLineTo(20.966f)
                curveTo(21.813f, 1.157f, 22.481f, 1.924f, 22.481f, 2.896f)
                verticalLineTo(13.928f)
                verticalLineTo(14.883f)
                verticalLineTo(20.161f)
                horizontalLineTo(22.486f)
                verticalLineTo(22.226f)
                curveTo(22.486f, 22.524f, 22.529f, 22.804f, 22.61f, 23.058f)
                horizontalLineTo(11.774f)
                verticalLineTo(23.059f)
                horizontalLineTo(4.234f)
                curveTo(2.827f, 23.059f, 1.707f, 21.776f, 1.707f, 20.161f)
                verticalLineTo(14.883f)
                verticalLineTo(13.928f)
                verticalLineTo(2.896f)
                curveTo(1.707f, 1.924f, 2.375f, 1.157f, 3.221f, 1.157f)
                close()
                moveTo(3.886f, 2.876f)
                curveTo(3.522f, 2.876f, 3.229f, 3.439f, 3.229f, 4.138f)
                verticalLineTo(9.419f)
                curveTo(3.229f, 10.118f, 3.522f, 10.681f, 3.886f, 10.681f)
                horizontalLineTo(9.485f)
                curveTo(9.849f, 10.681f, 10.142f, 10.118f, 10.142f, 9.419f)
                verticalLineTo(4.138f)
                curveTo(10.142f, 3.439f, 9.849f, 2.876f, 9.485f, 2.876f)
                horizontalLineTo(3.886f)
                close()
                moveTo(13.435f, 2.876f)
                curveTo(13.071f, 2.876f, 12.778f, 3.226f, 12.778f, 3.66f)
                curveTo(12.778f, 4.093f, 13.071f, 4.442f, 13.435f, 4.442f)
                horizontalLineTo(20.396f)
                curveTo(20.76f, 4.442f, 21.053f, 4.093f, 21.053f, 3.66f)
                curveTo(21.053f, 3.226f, 20.76f, 2.876f, 20.396f, 2.876f)
                horizontalLineTo(13.435f)
                close()
                moveTo(23.395f, 3.187f)
                curveTo(23.675f, 3.267f, 23.874f, 3.548f, 23.874f, 3.9f)
                verticalLineTo(22.314f)
                curveTo(23.874f, 22.32f, 23.873f, 22.328f, 23.873f, 22.336f)
                curveTo(23.872f, 22.373f, 23.869f, 22.409f, 23.864f, 22.444f)
                curveTo(23.861f, 22.462f, 23.858f, 22.479f, 23.855f, 22.497f)
                curveTo(23.817f, 22.685f, 23.72f, 22.842f, 23.585f, 22.942f)
                curveTo(23.571f, 22.925f, 23.552f, 22.898f, 23.527f, 22.849f)
                curveTo(23.461f, 22.723f, 23.399f, 22.491f, 23.399f, 22.226f)
                verticalLineTo(9.123f)
                horizontalLineTo(23.395f)
                lineTo(23.395f, 3.187f)
                close()
                moveTo(13.435f, 5.995f)
                curveTo(13.071f, 5.995f, 12.778f, 6.345f, 12.778f, 6.779f)
                curveTo(12.778f, 7.212f, 13.071f, 7.562f, 13.435f, 7.562f)
                horizontalLineTo(20.396f)
                curveTo(20.76f, 7.562f, 21.053f, 7.212f, 21.053f, 6.779f)
                curveTo(21.053f, 6.345f, 20.76f, 5.995f, 20.396f, 5.995f)
                horizontalLineTo(13.435f)
                close()
                moveTo(13.435f, 9.114f)
                curveTo(13.071f, 9.114f, 12.778f, 9.464f, 12.778f, 9.897f)
                curveTo(12.778f, 10.331f, 13.071f, 10.681f, 13.435f, 10.681f)
                horizontalLineTo(20.396f)
                curveTo(20.76f, 10.681f, 21.053f, 10.331f, 21.053f, 9.897f)
                curveTo(21.053f, 9.464f, 20.76f, 9.114f, 20.396f, 9.114f)
                horizontalLineTo(13.435f)
                close()
                moveTo(3.898f, 13.149f)
                curveTo(3.528f, 13.149f, 3.229f, 13.497f, 3.229f, 13.931f)
                curveTo(3.229f, 14.365f, 3.528f, 14.714f, 3.898f, 14.714f)
                horizontalLineTo(20.385f)
                curveTo(20.755f, 14.714f, 21.053f, 14.365f, 21.053f, 13.931f)
                curveTo(21.053f, 13.497f, 20.755f, 13.149f, 20.385f, 13.149f)
                horizontalLineTo(3.898f)
                close()
                moveTo(3.912f, 16.566f)
                curveTo(3.534f, 16.566f, 3.229f, 16.915f, 3.229f, 17.349f)
                curveTo(3.229f, 17.783f, 3.534f, 18.132f, 3.912f, 18.132f)
                horizontalLineTo(9.46f)
                curveTo(9.838f, 18.132f, 10.142f, 17.783f, 10.142f, 17.349f)
                curveTo(10.142f, 16.915f, 9.838f, 16.566f, 9.46f, 16.566f)
                horizontalLineTo(3.912f)
                close()
                moveTo(13.435f, 16.566f)
                curveTo(13.071f, 16.566f, 12.778f, 16.915f, 12.778f, 17.349f)
                curveTo(12.778f, 17.783f, 13.071f, 18.132f, 13.435f, 18.132f)
                horizontalLineTo(20.396f)
                curveTo(20.76f, 18.132f, 21.053f, 17.783f, 21.053f, 17.349f)
                curveTo(21.053f, 16.915f, 20.76f, 16.566f, 20.396f, 16.566f)
                horizontalLineTo(13.435f)
                close()
                moveTo(3.912f, 19.984f)
                curveTo(3.534f, 19.984f, 3.229f, 20.333f, 3.229f, 20.767f)
                curveTo(3.229f, 21.201f, 3.534f, 21.55f, 3.912f, 21.55f)
                horizontalLineTo(9.46f)
                curveTo(9.838f, 21.55f, 10.142f, 21.201f, 10.142f, 20.767f)
                curveTo(10.142f, 20.333f, 9.838f, 19.984f, 9.46f, 19.984f)
                horizontalLineTo(3.912f)
                close()
                moveTo(13.435f, 19.984f)
                curveTo(13.071f, 19.984f, 12.778f, 20.333f, 12.778f, 20.767f)
                curveTo(12.778f, 21.201f, 13.071f, 21.55f, 13.435f, 21.55f)
                horizontalLineTo(20.396f)
                curveTo(20.76f, 21.55f, 21.053f, 21.201f, 21.053f, 20.767f)
                curveTo(21.053f, 20.333f, 20.76f, 19.984f, 20.396f, 19.984f)
                horizontalLineTo(13.435f)
                close()
            }
        }
        .build()
        return _news!!
    }

private var _news: ImageVector? = null

@Preview
@Composable
private fun Preview(): Unit {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = newsIcon, contentDescription = "")
    }
}
