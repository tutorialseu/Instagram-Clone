package eu.tutorials.picsgram.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import eu.tutorials.picsgram.ui.screen.Login
import eu.tutorials.picsgram.ui.screen.SignUp

/**Todo 14: create MainScreen composable to serve as the host screen and create a
 * navHostController parameter then call Navigation composable and pass in as argument to it
 *
 */
@Composable
fun MainScreen(navHostController: NavHostController) {
    Navigation(navHostController = navHostController)
}
/**Todo 2: create MainScreen file and create Navigation composable
 * with [navHostController] as parameter
 */
@Composable
fun Navigation(navHostController: NavHostController) {
    /*Todo 3:we add a NavHost and assign navhostController to the parameter we created
    and set startDestination route as login this way when the app is launched login screen is displayed first
     */
    NavHost(navController = navHostController, startDestination = "login") {

        //Todo 4: Add a composable for login and set "login" as route
        composable("login") {
            Login(navController = navHostController)
        }

        //Todo 5: Add a composable for signup and set "signup" as route
        composable("signup") {
            SignUp(navController = navHostController)
        }

    }
}