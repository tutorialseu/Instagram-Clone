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

/**Todo 3: create Navigation class with @param [navController]
 * create the list of menus [tabs]
 * create [bottomRoutes] to get all routes in the [tabs] list
 * Since we have the login route which doesn't need a bottombar we create [shouldShowBottomBar] to
 * get the routes in bottombar and show the bar when in those routes
 * create [currentRoute] for getting the current screen route
 * Then we create a method [navigateToBottomBarRoute] for navigating between bottom bar items
 */
class Navigation(val navController: NavHostController) {

    val tabs = listOf(
        BottomMenu.Home,
        BottomMenu.Search, BottomMenu.Activity, BottomMenu.Account
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

/**Todo 4: create Navigation composable and pass in the [Navigation] class
 * Add [NavHost] and pass in navController from the navigation class and set login screen as the start
 * destination. Then we add a composable for [Login]
 * We then add a new [navigation] for the [BottomMenu] since its a nested navigation
 * And add composable for all bottom routes, we also add a route "main" for the navigation
 */
@Composable
fun Navigation(navigation: Navigation) {
    NavHost(navController = navigation.navController, startDestination = "login"){

        composable("login"){
            //Todo 7: pass in navigation argument
            Login(navigation = navigation)
        }

        navigation(BottomMenu.Home.route,"main"){
            composable(BottomMenu.Home.route){

            }

            composable(BottomMenu.Search.route){

            }

            composable(BottomMenu.Activity.route){

            }

            composable(BottomMenu.Account.route){

            }
        }

    }
}