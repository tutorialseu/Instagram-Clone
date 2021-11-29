package eu.tutorials.picsgram.ui.screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.skydoves.landscapist.coil.CoilImage
import eu.tutorials.picsgram.Manager

@ExperimentalFoundationApi
@Composable
fun Search() {
    Manager.displayGrid()
    LazyVerticalGrid(cells = GridCells.Adaptive(minSize = 128.dp)){
      val posts = Manager.gridPosts
        items(posts.value){
          CoilImage(imageModel = it.image)
      }
    }
}