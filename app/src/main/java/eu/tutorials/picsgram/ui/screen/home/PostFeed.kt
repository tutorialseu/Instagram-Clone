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

//Todo 1 create a Post file with a composable and add a LazyColumn
@Composable
fun PostFeed() {
    //Todo 18 we call the displayPosts method from HomeManager that adds the posts
   HomeManager.displayPosts()
    LazyColumn(modifier = Modifier.padding(top = 16.dp)) {
        //Todo 19 we assign posts to a variable, call items and set the posts value
        val posts = HomeManager.posts
      items(posts.value){
          //Todo 20: add PostItem and assign the value returned from the items lambda to respective PostItem variable
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

//Todo 2: create a composable for each PostItem
@Composable
fun PostItem(
    //Todo 5: Add a parameter for the item values
    userImage: String, userName: String, postImage: String,
    caption: String, timeAgo: String
) {
    //Todo 6: Add a Column as the parent element then add a Row within it for the first section of the UI
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            //Todo 13 : add a horizontalArrangement with SpaceBetween to push the IconButton to the
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            //Todo 7: looking at the UI structure we add another Row for the User info with start and top padding of 8dp
            //and vertical alignment to center
            Row(
                modifier = Modifier.padding(start = 8.dp, top = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                //Todo 8: For the Image we add a Box with fixed size of 30dp, a gray background color and a Circleshape
                //then a clip the image to the  CircleShape
                Box(
                    modifier = Modifier
                        .size(30.dp)
                        .background(color = Color.LightGray, shape = CircleShape)
                        .clip(CircleShape)
                ) {
                    //Todo 9 We add a CoilImage because we are using an image from a network and set it to fillMaxSize and the imageModel as userImage
                    CoilImage(
                        imageModel = userImage,
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize()
                    )
                }
                //Todo 10: We add a Text for the Username with a padding start of 8dp and set font weight to Bold and the text as userName
                Text(
                    text = userName,
                    modifier = Modifier.padding(start = 8.dp),
                    fontWeight = FontWeight.Bold
                )
            }
                //Todo 11 we add an IconButton and set the Icon to MoreVert
            IconButton(onClick = {}) {
                Icon(imageVector = Icons.Default.MoreVert, contentDescription = null)
            }
        }
        //Todo 14: add CoilImage for post image and set imageModel value to postImage parameter
        CoilImage(imageModel = postImage)
        //Todo 15: add an IconButton with Icon set to Favorite Border
        IconButton(onClick = {}) {
            Icon(imageVector = Icons.Outlined.FavoriteBorder, contentDescription = null)
        }
        //Todo 16: Add a Row with padding start of 8dp and add a Text for username with fontWeight set to bold and padding start of 8dp
        // and Text for post caption with padding start set to 8dp
        Row(modifier = Modifier.padding(start = 8.dp)) {
            Text(text = userName, fontWeight = FontWeight.Bold)
            Text(text = caption, modifier = Modifier.padding(start = 8.dp))
        }
        //Todo 17 we add a Text to show time ago
        Text(text = timeAgo, modifier = Modifier.padding(start = 8.dp))
    }
}

//Todo 12 We add a preview function and rebuild the image
@Preview(showBackground = true)
@Composable
fun PostItemPreview() {
   PostItem(userImage = "",userName = "Username",postImage = "",caption = "Caption",
   timeAgo = "30 Minutes")
}