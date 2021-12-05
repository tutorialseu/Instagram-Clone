package eu.tutorials.picsgram.ui.screen.main

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import eu.tutorials.picsgram.ui.screen.MainViewModel


@Composable
fun MainScreen(navController: NavHostController,viewModel: MainViewModel) {
    Navigation(navHostController = navController,viewModel = viewModel)

}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MainScreen(rememberNavController(), viewModel())
}