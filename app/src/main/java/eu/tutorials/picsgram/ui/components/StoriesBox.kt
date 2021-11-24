package eu.tutorials.picsgram.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import com.skydoves.landscapist.coil.CoilImage

@Composable
fun StoriesBox(shape:Shape,image:String) {
    Box(
        Modifier.border(
            width = 2.dp,
            brush = Brush.linearGradient(
                colors = listOf(
                    Color(0xFFd71069),
                    Color(0xFFe25d6a),
                    Color(0xFFe9ad55),
                ), start = Offset(100f, 0.0f), end = Offset(0.0f, 100f)
            ),
            shape = shape
        )
    ) {
        Box(
            modifier = Modifier
                .size(60.dp)
                .padding(6.dp)
                .background(color = Color.LightGray, shape = shape)
                .clip(shape)
        ) {
            CoilImage(
               imageModel = image,
                contentDescription = "",
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}