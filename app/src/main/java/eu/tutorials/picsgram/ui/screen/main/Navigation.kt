package eu.tutorials.picsgram.ui.screen.main

import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import eu.tutorials.picsgram.ui.screen.Login
import eu.tutorials.picsgram.ui.viewmodel.MainViewModel
import eu.tutorials.picsgram.ui.screen.ProfileScreen
import eu.tutorials.picsgram.ui.screen.SignUp


@ExperimentalPermissionsApi
@Composable
fun Navigation(navHostController: NavHostController,viewModel: MainViewModel) {


    val scrollState = rememberScrollState()
    NavHost(navController = navHostController, startDestination = "login") {

        composable("login") {
            Login(navController = navHostController,scrollState = scrollState,viewModel = viewModel)
        }

        composable("signup") {
            SignUp(navController = navHostController,scrollState = scrollState,viewModel = viewModel)
        }
        composable("profile") {
            ProfileScreen(viewModel,navController = navHostController)
        }
    }
}