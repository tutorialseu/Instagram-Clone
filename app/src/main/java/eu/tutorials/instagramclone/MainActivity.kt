package eu.tutorials.instagramclone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import eu.tutorials.instagramclone.ui.screen.Login
import eu.tutorials.instagramclone.ui.screen.main.MainScreen
import eu.tutorials.instagramclone.ui.screen.main.Navigation
import eu.tutorials.instagramclone.ui.theme.IntagramCloneTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IntagramCloneTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    InstagramApp()
                }
            }
        }
    }
}

@Composable
fun InstagramApp() {
    //Todo 10: create remember navcontroller and initialize navigation
    val navController = rememberNavController()
    val navigation=Navigation(navController = navController)
    //Todo 11: Replace Login with MainScreen
  MainScreen(navigation = navigation)
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    IntagramCloneTheme {
    }
}