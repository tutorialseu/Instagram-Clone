package eu.tutorials.picsgram.ui.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.Bottom
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.skydoves.landscapist.coil.CoilImage
import eu.tutorials.picsgram.Manager
import eu.tutorials.picsgram.model.Activity
import eu.tutorials.picsgram.model.Post
import eu.tutorials.picsgram.model.User

//Todo 7: create Activity file and a composable within it
@Composable
fun Activity() {
    //Todo 13 We call the displayActivity from then Manager class
    Manager.displayActivity()
    /*Todo 14: We add a lazyColumn the fetch the activity post
    *  then we group the post by topic using groupBy kotlin function
    * We loop through the grouped post and get the topic and posts under it
    * Within the loop we add item which is for unique keys like the topic and then add a Text to display each topic
    * with vertical and horizontal padding of 8dp and width set to fillParentMaxWidth
    * then we add items for each topic and pass in the  posts with ActivityItem set as its content
    * and returned activity set as its argument
    * */
    LazyColumn {
        val posts = Manager.activityPost
        val grouped = posts.value.groupBy { it.topic }
        grouped.forEach { (topic, posts) ->
            item {
                Text(
                    text = topic, modifier = Modifier
                        .fillParentMaxWidth()
                        .padding(vertical = 8.dp, horizontal = 8.dp)
                )
            }
            items(posts) { activity ->
                ActivityItem(activity = activity)
            }
        }

    }
}

//Todo 8 create an Activity Item with an Activity parameter
@Composable
fun ActivityItem(activity: Activity) {
    /*Todo 9: Add a Row and set Modifier to fill MaxWidth, padding to 8dp, border with BorderStroke
    *  width set to 2dp, color set to lightGray and shape set to RoundedCornerShape with 4 percent
    * The Row verticalAlignment set to Bottom
    * */
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .border(
                border = BorderStroke(2.dp, color = Color.LightGray),
                shape = RoundedCornerShape(4)
            ), verticalAlignment = Bottom
    ) {
        //Todo 10: We add a CoilImage with imageModel set to image from the post and size set to 200dp
        CoilImage(imageModel = activity.post.image, modifier = Modifier.size(200.dp))
        //Todo 11: Add a Button with padding start and bottom set to 32dp then content set to Text with text as "Click To View"
        Button(onClick = { }, modifier = Modifier.padding(start = 32.dp, bottom = 32.dp)) {
            Text(text = "Click To VIew")
        }
    }
}

//Todo 12: add a preview function fot ActivityItem
@Preview
@Composable
fun ActivityItemPreview() {
    ActivityItem(
        activity = Activity(
            "Tech",
            post = Post("", user = User("username", "username", ""),
                "Captions", "30 minutes Ago")
        )
    )
}