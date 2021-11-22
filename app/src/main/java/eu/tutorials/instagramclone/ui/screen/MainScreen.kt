package eu.tutorials.instagramclone.ui.screen

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import eu.tutorials.instagramclone.model.BottomMenu

//Todo 1: create MainScreen with a composable function
@Composable
fun MainScreen() {
    //Todo 2: Add a Scaffold as the parent layout and call the bottomBar
    Scaffold(bottomBar = {
        //Todo 7: pass HomeBottomBar as the bottomBar
        HomeBottomBar()
    }) {

    }
}

//Todo 4: Create BottomBar composable
@Composable
fun HomeBottomBar() {
    //Todo 5: create a list of the menu items from the BottomMenu class we created
    val tabs = listOf(
        BottomMenu.Home,
        BottomMenu.Search, BottomMenu.Reels, BottomMenu.Activity, BottomMenu.Account
    )
    /*Todo 6: Call the BottomNavigation element and set background color to white,loop
        through each item and set a BottomNavigationItem for it with setting a few properties like selected to false, leave onclick empty
    then set icon to the default icon with a color tint of black
     */
    BottomNavigation(backgroundColor = Color.White) {
        tabs.forEach {
            BottomNavigationItem(selected = false, onClick = { }, icon = {
                Icon(
                    imageVector = it.icon,
                    contentDescription = it.label,
                    tint = Color.Black
                )
            })
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MainScreen()
}