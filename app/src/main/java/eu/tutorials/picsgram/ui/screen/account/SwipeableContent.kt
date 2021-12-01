package eu.tutorials.picsgram.ui.screen.account

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.skydoves.landscapist.coil.CoilImage
import eu.tutorials.picsgram.Manager
import eu.tutorials.picsgram.Manager.posts
import eu.tutorials.picsgram.model.Post
import eu.tutorials.picsgram.model.Story


//Todo 6: create a File for the SwipeableContent and create Post Swipeable
@ExperimentalFoundationApi
@Composable
fun PostSwipeable() {
    //Todo 7: Add a LazyVerticalGrid as we want the list as a grid and set the minimum size for each cell to 128
    //then add the experimental annotation since the api is experimental
    LazyVerticalGrid(cells = GridCells.Adaptive(minSize = 128.dp)) {
        //Todo 8: Pass in items with posts value from the Manager class and set CoilImage as the content
        //and image from the returned object as argument
        items(posts.value) {
            CoilImage(imageModel = it.image)
        }
    }
}


@ExperimentalFoundationApi
@Composable
fun StorySwipeable() {
    //Todo 9: Add a LazyVerticalGrid with the minimum size for each cell set to 128
    //then add the experimental annotation
    LazyVerticalGrid(cells = GridCells.Adaptive(minSize = 128.dp)) {
        //Todo 10: Pass in items with stories value from the Manager class and set CoilImage as the content
        //and image from the returned object as argument
        items(Manager.stories.value) {
            CoilImage(imageModel = it.image)
        }
    }
}