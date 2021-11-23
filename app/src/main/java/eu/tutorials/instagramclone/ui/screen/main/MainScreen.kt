package eu.tutorials.instagramclone.ui.screen.main

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import eu.tutorials.instagramclone.model.BottomMenu
import eu.tutorials.instagramclone.ui.screen.main.Navigation
//Todo 2:create main package in screen and move MainScreen.kt into it
//Todo 8: Create Navigation variable and pass into HomeBottomBar
@Composable
fun MainScreen(navigation: Navigation) {
    Scaffold(bottomBar = {
        //Todo 12: check if current route is part of the bottom route and show bottom bar
        if (navigation.shouldShowBottomBar) {
            //Todo 21: pass in navigation as argument
            HomeBottomBar(navigation = navigation)
        }
    }) {
        //Todo 9 set Navigation as Scaffold content
      Navigation(navigation = navigation)
    }
}

//Todo 13: create navigation variable
@Composable
fun HomeBottomBar(navigation: Navigation) {

    BottomNavigation(backgroundColor = Color.White) {
        //Todo 14: use tab from navigation class
        navigation.tabs.forEach {
            //Todo 15 set selected route to true if current route from navigation equals the selected tab
            val selected = navigation.currentRoute == it.route
            //Todo 16 change icon to filled if selected else use outlined icon
            val icon = if (selected) it.selectedIcon else it.icon
            //Todo 17 replace selected value
            BottomNavigationItem(selected = selected, onClick = {
                //Todo 18 pass method from the navigation class to move to selected screens
                navigation.navigateToBottomBarRoute(it.route)
            }, icon = {
                Icon(
                    //Todo 19: replace icon to change when selected
                    imageVector = icon,
                    contentDescription = it.label,
                    tint = Color.Black
                )
            })
        }
    }
}

//Todo 20 update the preview function with Navigation argument
@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MainScreen(Navigation(rememberNavController()))
}