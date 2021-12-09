package eu.tutorials.picsgram

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Base64
import java.io.ByteArrayOutputStream
import java.util.regex.Matcher
import java.util.regex.Pattern

object Utils {
        // digit + lowercase char + uppercase char + punctuation + symbol
        private const val PASSWORD_PATTERN =
            "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{6,}$"
        private val pattern: Pattern = Pattern.compile(PASSWORD_PATTERN)
        fun isValid(password: String?): Boolean {
            val matcher: Matcher = pattern.matcher(password)
            return matcher.matches()
        }

    fun Bitmap.bitmapToBase64():String {
        val byteArrayOutputStream = ByteArrayOutputStream()
        this.compress(Bitmap.CompressFormat.JPEG, 50, byteArrayOutputStream)
        val imageBytes: ByteArray = byteArrayOutputStream.toByteArray()
        return Base64.encodeToString(imageBytes, Base64.DEFAULT)
    }

    fun String.base64ToByteCode():Bitmap {
       val decodedString =  Base64.decode(this.substring(this.indexOf(",") + 1), Base64.DEFAULT)
        return BitmapFactory.decodeByteArray(decodedString, 0, decodedString.size)
    }
}