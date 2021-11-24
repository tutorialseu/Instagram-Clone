package eu.tutorials.picsgram

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import eu.tutorials.picsgram.ui.screen.MainPage
import eu.tutorials.picsgram.ui.theme.IntagramCloneTheme

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
    MainPage()
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    IntagramCloneTheme {
    }
}