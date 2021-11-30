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

@Composable
fun Activity() {
    Manager.displayActivity()
    val posts = Manager.activityPost
    LazyColumn {
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


@Composable
fun ActivityItem(activity: Activity) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .border(
                border = BorderStroke(2.dp, color = Color.LightGray),
                shape = RoundedCornerShape(4)
            ), verticalAlignment = Bottom
    ) {

        CoilImage(imageModel = activity.post.image, modifier = Modifier.size(200.dp))
        Button(onClick = { }, modifier = Modifier.padding(start = 32.dp, bottom = 32.dp)) {
            Text(text = "Click To VIew")
        }
    }
}

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