package eu.tutorials.picsgram

import androidx.compose.runtime.Composable
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import eu.tutorials.picsgram.model.BottomMenu

class InstagramAppState(val navController: NavController) {

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
        if (route != currentRoute) {
            navController.navigate(route) {
                launchSingleTop = true
                restoreState = true
                navController.graph.startDestinationRoute?.let { route ->
                    popUpTo(route) {
                        saveState = true
                        inclusive = true
                    }
                }
            }
        }
    }

    fun navigateToAuth(from: NavBackStackEntry) {
        if (from.lifecycleIsResumed()) {
            navController.navigate("auth") {
                launchSingleTop = true

                popUpTo("auth") {
                    saveState = true
                    inclusive = true
                }
            }
        }
    }

    private fun NavBackStackEntry.lifecycleIsResumed() =
        this.lifecycle.currentState == Lifecycle.State.RESUMED


}