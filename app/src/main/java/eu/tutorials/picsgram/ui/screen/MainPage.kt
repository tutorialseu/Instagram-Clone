package eu.tutorials.picsgram.ui.screen

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.rememberNavController
import eu.tutorials.picsgram.InstagramAppState
import eu.tutorials.picsgram.ui.Navigation

@Composable
fun MainPage() {
    val navController = rememberNavController()
    val appState = InstagramAppState(navController)
    Scaffold(bottomBar = {
        if (appState.shouldShowBottomBar) {
            MainBottomMenu(appState)
        }
    }) {
        Navigation(controller = navController,appState)
    }
}


@Composable
fun MainBottomMenu(appState:InstagramAppState) {

    BottomNavigation(backgroundColor = Color.White) {
        appState.tabs.forEach {
            val selected =appState.currentRoute==it.route
            val icon = if (selected)it.selectedIcon else it.icon
            BottomNavigationItem(selected = selected, onClick = {appState.navigateToBottomBarRoute(it.route) }, icon = {
                Icon(
                    imageVector = icon,
                    contentDescription = it.label,
                    tint = Color.Black
                )
            })
        }

    }
}