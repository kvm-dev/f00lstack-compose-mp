package ru.kvmsoft.base.ui.utils

import androidx.compose.ui.graphics.ImageBitmap
import org.jetbrains.compose.resources.decodeToImageBitmap
import kotlin.io.encoding.Base64

//android
//fun String.decodeBase64ToBitmap(): ImageBitmap? {
//    return try {
//        val imageBytes = Base64.decode(this.substringAfter("base64,"), Base64.DEFAULT)
//        val bitmap = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.size)
//        bitmap.asImageBitmap()
//    } catch (e: Exception) {
//        null
//    }
//}
//
fun String.decodeBase64ToBitmap(): ImageBitmap?{
    return  (Base64.decode(this.encodeToByteArray())).decodeToImageBitmap()
}