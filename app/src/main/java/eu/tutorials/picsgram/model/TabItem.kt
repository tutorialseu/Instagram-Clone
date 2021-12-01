package eu.tutorials.picsgram.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Apps
import androidx.compose.material.icons.filled.LibraryBooks
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector

/*Todo 7: create a template for the tab items
Containing icon as ImageVector, title as String and composable as screen
 */

sealed class TabItem(val icon: ImageVector, val title: String,  val screen: @Composable () -> Unit) {
    object Posts : TabItem(Icons.Default.Apps, title = "Posts", { })
    object Stories : TabItem(Icons.Default.LibraryBooks, title = "Stories", {  })
}
