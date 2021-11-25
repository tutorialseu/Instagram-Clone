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

//Todo 1: create Stories file with a composable and add LazyRow
@Composable
fun Stories() {
    //Todo 8: create a mutableList of Story
    val stories = mutableListOf<Story>()
    //Todo 9 create a a dummy list of 10 items from 0 to 9 index create a story and add to stories list
    (0..9).forEach { index ->
        val story = Story(
            image = "https://source.unsplash.com/random/${index + 1}.jpg",
            name = "User + $index"
        )
        stories.add(story)
    }
    //Todo 10: Add a start and top padding of 8dp
    LazyRow(modifier = Modifier.padding(start = 8.dp, top = 8.dp)) {
        /*
        Todo 11: set items with the value as stories then add a Column as a parent for its content
         with a horizontal padding of 4dp
         Call the Story Item and set its argument as the image from the stories list
         */
        items(stories) { story ->
            Column(modifier = Modifier.padding(horizontal = 4.dp)) {
                Log.d("story", story.name)
                StoryItem(image = story.image)
            }

        }
    }
}

/**Todo 2 We want each story item to have a Circle Shape with a gradient border of mixed colors
 * so we create a CircleShape value and add Box as the parent with a border of width set to 2dp
 * brush set to LinearGradient with list of 2 colors and a start and end offset
 */
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
        //Todo 3: we add a Card within the Box with a 60dp width and padding of 6dp
        //and set background color of lightGray, set a circle shape and a clip to circle shape as well
        Card(
            modifier = Modifier
                .size(60.dp)
                .padding(6.dp)
                .background(color = Color.LightGray, shape = shape)
                .clip(shape)
        ) {
            //Todo 5: We add a CoilImage and set imageModel to the Image from the parameter and modifier to fillMaxSize
            CoilImage(
                imageModel = image,
                contentDescription = "",
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}

//Todo 6: create a preview function for the Story Item
@Preview(showBackground = true)
@Composable
fun StoryItemPreview() {
    StoryItem(image = "")
}