package eu.tutorials.picsgram.ui.screen.main

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController

//Todo 14: Add the experimental annotation
//start
@ExperimentalFoundationApi
//end
@Composable
fun MainScreen(navigation: Navigation) {
    Scaffold(bottomBar = {
       if (navigation.shouldShowBottomBar) {
            HomeBottomBar(navigation = navigation)
        }
    }) {
        //Todo 20: Pass in the padding value from scaffold
  Navigation(navigation = navigation,paddingValues = it)
    }
}
@Composable
fun HomeBottomBar(navigation: Navigation) {
    BottomNavigation(backgroundColor = Color.White) {
        navigation.tabs.forEach {
            val selected = navigation.currentRoute == it.route
           val icon = if (selected) it.selectedIcon else it.icon
            BottomNavigationItem(selected = selected, onClick = {
               navigation.navigateToBottomBarRoute(it.route)
            }, icon = {
                Icon(
                imageVector = icon,
                    contentDescription = it.label,
                    tint = Color.Black
                )
            })
        }
    }
}

//Todo 15: Add the experimental annotation
//start
@ExperimentalFoundationApi
//end
@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MainScreen(Navigation(rememberNavController()))
}