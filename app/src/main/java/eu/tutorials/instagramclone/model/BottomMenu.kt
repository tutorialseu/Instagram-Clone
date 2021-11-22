package eu.tutorials.instagramclone.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomMenu(val route:String, val label:String, val icon: ImageVector,val selectedIcon: ImageVector){
    object Home:BottomMenu("home","Home", Icons.Outlined.Home, Icons.Filled.Home)
    object Search:BottomMenu("search","Search",Icons.Outlined.Search,Icons.Filled.Search)
    object Reels:BottomMenu("reels","Reels",  Icons.Outlined.OndemandVideo,Icons.Filled.OndemandVideo)
    object Activity:BottomMenu("activity","Activity", Icons.Outlined.FavoriteBorder,Icons.Filled.Favorite)
    object Account:BottomMenu("account","Account",Icons.Outlined.AccountCircle,Icons.Filled.AccountCircle)
}
