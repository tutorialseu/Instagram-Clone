package eu.tutorials.picsgram.ui.screen.main

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.navigation
import eu.tutorials.picsgram.model.BottomMenu
import eu.tutorials.picsgram.ui.screen.Activity
import eu.tutorials.picsgram.ui.screen.Login
import eu.tutorials.picsgram.ui.screen.Search
import eu.tutorials.picsgram.ui.screen.SignUp
import eu.tutorials.picsgram.ui.screen.account.Account
import eu.tutorials.picsgram.ui.screen.home.Home

class Navigation(val navController: NavHostController) {

    val tabs = listOf(
        BottomMenu.Home,
        BottomMenu.Search, BottomMenu.Activity, BottomMenu.Account
    )

    val bottomRoutes = tabs.map { it.route }

    val shouldShowBottomBar: Boolean
        @Composable get() = navController
            .currentBackStackEntryAsState().value?.destination?.route in bottomRoutes

    val currentRoute: String?
        get() = navController.currentDestination?.route

    fun navigateToBottomBarRoute(route: String) {
        navController.navigate(route) {
            popUpTo("login") {
                saveState = true
                inclusive = true

            }
            launchSingleTop = true
            restoreState = true
        }
    }
}


@ExperimentalFoundationApi
@Composable
fun Navigation(
    navigation: Navigation,
    paddingValues: PaddingValues
) {
    NavHost(
        navController = navigation.navController, startDestination = "login",
        modifier = Modifier.padding(paddingValues = paddingValues)
    ) {

        composable("login") {
            Login(navigation = navigation)
        }

        composable("signup") {
            SignUp(navigation = navigation)
        }

        navigation(BottomMenu.Home.route, "main") {
            composable(BottomMenu.Home.route) {
                Home()
            }

            composable(BottomMenu.Search.route) {
                Search()
            }

            composable(BottomMenu.Activity.route) {
                Activity()
            }

            composable(BottomMenu.Account.route) {
                //Todo 5: add Account to its bottom route
                Account()
            }
        }

    }
}