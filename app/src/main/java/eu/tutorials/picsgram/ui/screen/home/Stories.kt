package eu.tutorials.picsgram.ui.screen.home

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.skydoves.landscapist.coil.CoilImage
import eu.tutorials.picsgram.R
import androidx.compose.ui.geometry.Offset
import eu.tutorials.picsgram.model.Story

@Composable
fun Stories() {
   val stories = mutableListOf<Story>()
    (0..9).forEach { index ->
        val story = Story(
            image = "https://source.unsplash.com/random/${index + 1}.jpg",
            name = "User + $index"
        )
        stories.add(story)
    }

    LazyRow(modifier = Modifier.padding(start = 8.dp, top = 8.dp)) {

        items(stories) { story ->
            Column(modifier = Modifier.padding(horizontal = 4.dp)) {
                Log.d("story", story.name)
                StoryItem(image = story.image)
            }

        }
    }
}

@Composable
fun StoryItem(image: String) {
    val shape = CircleShape
    Box(
        Modifier.border(
            width = 2.dp,
            brush = Brush.linearGradient(
                colors =
                listOf(colorResource(id = R.color.purple_500), Color.Red),
                start = Offset(100f, 0.0f), end = Offset(0.0f, 100f)
            ),
            shape = shape,
        )
    ) {

        Card(
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

@Preview(showBackground = true)
@Composable
fun StoryItemPreview() {
    StoryItem(image = "")
}