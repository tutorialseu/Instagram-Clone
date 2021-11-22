package eu.tutorials.instagramclone.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import eu.tutorials.instagramclone.InstagramAppState
import eu.tutorials.instagramclone.model.BottomMenu
import eu.tutorials.instagramclone.ui.screen.*
import eu.tutorials.instagramclone.ui.screen.home.Home

@Composable
fun Navigation(controller: NavHostController,appState: InstagramAppState) {
NavHost(navController = controller, startDestination = "login",route = "auth"){

  composable("login"){
    Login(navController = controller)
  }
    navigation(BottomMenu.Home.route, "main"){
        composable(BottomMenu.Home.route){
            Home()
        }
        composable(BottomMenu.Search.route){
            Search()
        }
        composable(BottomMenu.Reels.route){
            Reels()
        }
        composable(BottomMenu.Activity.route){
            Activities()
        }
        composable(BottomMenu.Account.route){
            Account()
        }
    }
}
}
