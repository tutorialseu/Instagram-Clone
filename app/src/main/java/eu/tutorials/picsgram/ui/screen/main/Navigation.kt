package eu.tutorials.picsgram.ui.screen.main

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.navigation
import eu.tutorials.picsgram.model.BottomMenu
import eu.tutorials.picsgram.ui.screen.Login

class Navigation(val navController: NavHostController) {

    val tabs = listOf(
        BottomMenu.Home,
        BottomMenu.Search, BottomMenu.Reels, BottomMenu.Activity, BottomMenu.Account
    )

    val bottomRoutes = tabs.map { it.route }

    // Reading this attribute will cause recompositions when the bottom bar needs shown, or not.
    // Not all routes need to show the bottom bar.
    val shouldShowBottomBar: Boolean
        @Composable get() = navController
            .currentBackStackEntryAsState().value?.destination?.route in bottomRoutes

    val currentRoute: String?
        get() = navController.currentDestination?.route

    fun navigateToBottomBarRoute(route: String) {
            navController.navigate(route) {
                 popUpTo(navController.graph.findStartDestination().id) {
                        saveState = true

                }
                launchSingleTop = true
                restoreState = true
        }
    }
}

@Composable
fun Navigation(navigation: Navigation) {
    NavHost(navController = navigation.navController, startDestination = "login"){

        composable("login"){
            Login(navigation = navigation)
        }

        navigation(BottomMenu.Home.route,"main"){
            composable(BottomMenu.Home.route){

            }

            composable(BottomMenu.Search.route){

            }

            composable(BottomMenu.Reels.route){

            }

            composable(BottomMenu.Activity.route){

            }

            composable(BottomMenu.Account.route){

            }
        }

    }
}