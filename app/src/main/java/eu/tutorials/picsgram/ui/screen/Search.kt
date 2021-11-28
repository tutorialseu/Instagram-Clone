package eu.tutorials.picsgram.ui.screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.skydoves.landscapist.coil.CoilImage
import eu.tutorials.picsgram.Manager

//Todo 1: create a Search file and a composable within it
//start
@ExperimentalFoundationApi
//end
@Composable
fun Search() {
    //Todo 8: call the displayGrid method
    Manager.displayGrid()
    //Todo 2: Add a LazyVerticalGrid and assign Adaptive GridCells with minimum size of 128dp
    //AdaptiveCells creates no of cells depending on the screen width and minSize
    LazyVerticalGrid(cells = GridCells.Adaptive(minSize = 128.dp)){
        //Todo 9: assign gridposts state list to a variable
      val posts = Manager.gridPosts
        //Todo 10 add items for the Grid and pass in the value from the grid post
        items(posts.value){
        //Todo 11 Add CoilImage and set imageModel as the image from returned from the items object
          CoilImage(imageModel = it.image)
      }
    }
}