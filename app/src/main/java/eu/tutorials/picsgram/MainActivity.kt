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
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import eu.tutorials.picsgram.ui.viewmodel.MainViewModel
import eu.tutorials.picsgram.ui.screen.main.MainScreen
import eu.tutorials.picsgram.ui.theme.PicsGramTheme
import eu.tutorials.picsgram.ui.viewmodel.MainViewModelFactory


class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels {
        MainViewModelFactory(repository =  (application as App).repository)

    }

    @ExperimentalPermissionsApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PicsGramTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    PicsGramApp(viewModel)
                }
            }
        }
    }
}


@ExperimentalPermissionsApi
@Composable
fun PicsGramApp(viewModel: MainViewModel) {
    val navController = rememberNavController()
    MainScreen(navController = navController, viewModel = viewModel)
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PicsGramTheme {
    }
}