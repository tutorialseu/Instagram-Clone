package eu.tutorials.picsgram

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import eu.tutorials.picsgram.ui.screen.MainViewModel
import eu.tutorials.picsgram.ui.screen.main.MainScreen
import eu.tutorials.picsgram.ui.theme.IntagramCloneTheme


class MainActivity : ComponentActivity() {
    private val viewModel by viewModels<MainViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IntagramCloneTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    PicsGramApp(viewModel)
                }
            }
        }
    }
}


@Composable
fun PicsGramApp(viewModel: MainViewModel) {
val navController = rememberNavController()
  MainScreen(navController = navController,viewModel = viewModel)
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    IntagramCloneTheme {
    }
}