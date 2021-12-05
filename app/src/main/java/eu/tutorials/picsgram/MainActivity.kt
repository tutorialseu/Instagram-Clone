package eu.tutorials.picsgram

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import eu.tutorials.picsgram.ui.MainScreen
import eu.tutorials.picsgram.ui.screen.Login
import eu.tutorials.picsgram.ui.theme.PicsGramTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PicsGramTheme() {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    PicsGramApp()
                }
            }
        }
    }
}

@Composable
fun PicsGramApp() {
    /*Todo 17: create rememberNavController, replace Login composable with MainScreen since we have a
    NavHost controlling the destinations to be displayed and pass in navController
    */
    val navController = rememberNavController()
    MainScreen(navHostController = navController)
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PicsGramTheme {
    }
}