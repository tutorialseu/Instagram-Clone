package eu.tutorials.picsgram.ui.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.skydoves.landscapist.coil.CoilImage
import eu.tutorials.picsgram.Manager

@Composable
fun PostFeed() {
   Manager.displayPosts()
    LazyColumn(modifier = Modifier.padding(top = 16.dp)) {
        val posts = Manager.posts
      items(posts.value){
          PostItem(
              userImage = it.user.image,
              userName = it.user.name,
              postImage = it.image,
              caption = it.captions,
              timeAgo = it.postedAt
          )
      }
    }
}

@Composable
fun PostItem(
    userImage: String, userName: String, postImage: String,
    caption: String, timeAgo: String
) {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier.padding(start = 8.dp, top = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(30.dp)
                        .background(color = Color.LightGray, shape = CircleShape)
                        .clip(CircleShape)
                ) {
                    CoilImage(
                        imageModel = userImage,
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize()
                    )
                }
                Text(
                    text = userName,
                    modifier = Modifier.padding(start = 8.dp),
                    fontWeight = FontWeight.Bold
                )
            }
            IconButton(onClick = {}) {
                Icon(imageVector = Icons.Default.MoreVert, contentDescription = null)
            }
        }
        CoilImage(imageModel = postImage)
        IconButton(onClick = {}) {
            Icon(imageVector = Icons.Outlined.FavoriteBorder, contentDescription = null)
        }
        Row(modifier = Modifier.padding(start = 8.dp)) {
            Text(text = userName, fontWeight = FontWeight.Bold)
            Text(text = caption, modifier = Modifier.padding(start = 8.dp))
        }
        Text(text = timeAgo, modifier = Modifier.padding(start = 8.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun PostItemPreview() {
   PostItem(userImage = "",userName = "Username",postImage = "",caption = "Caption",
   timeAgo = "30 Minutes")
}