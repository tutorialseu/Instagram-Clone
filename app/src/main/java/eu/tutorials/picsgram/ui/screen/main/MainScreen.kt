package eu.tutorials.picsgram.ui.screen.main

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController


@ExperimentalFoundationApi
@Composable
fun MainScreen(navigation: Navigation) {
    Scaffold(bottomBar = {
       if (navigation.shouldShowBottomBar) {
            HomeBottomBar(navigation = navigation)
        }
    }) {
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


@ExperimentalFoundationApi
@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MainScreen(Navigation(rememberNavController()))
}