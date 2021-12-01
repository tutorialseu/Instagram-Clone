package eu.tutorials.picsgram.model

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Apps
import androidx.compose.material.icons.filled.LibraryBooks
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import eu.tutorials.picsgram.ui.screen.account.PostSwipeable
import eu.tutorials.picsgram.ui.screen.account.StorySwipeable

//Todo 13 Add the experimental foundation since the composables has it annotated
@ExperimentalFoundationApi
sealed class TabItem(val icon: ImageVector, val title: String,  val screen: @Composable () -> Unit) {
    object Posts : TabItem(Icons.Default.Apps, title = "Posts", {
        //Todo 11: pass in PostSwipeable as the composable for Posts
        PostSwipeable()})
    object Stories : TabItem(Icons.Default.LibraryBooks, title = "Stories", {
        //todo 12:Pass in StorySwipeable as the composable for Stories
        StorySwipeable() })
}
