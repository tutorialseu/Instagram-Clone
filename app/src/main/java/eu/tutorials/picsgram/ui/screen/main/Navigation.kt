package eu.tutorials.picsgram.ui.screen.main

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import eu.tutorials.picsgram.ui.screen.Login
import eu.tutorials.picsgram.ui.screen.MainViewModel
import eu.tutorials.picsgram.ui.screen.ProfileScreen
import eu.tutorials.picsgram.ui.screen.SignUp


@Composable
fun Navigation(navHostController: NavHostController,viewModel: MainViewModel) {
    NavHost(navController = navHostController, startDestination = "login") {

        composable("login") {
            Login(navController = navHostController)
        }

        composable("signup") {
            SignUp(navController = navHostController)
        }
        composable("profile") {
            ProfileScreen(viewModel)
        }
    }
}