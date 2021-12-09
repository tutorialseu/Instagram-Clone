package eu.tutorials.picsgram.ui.screen.main

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import eu.tutorials.picsgram.ui.viewmodel.MainViewModel


@ExperimentalPermissionsApi
@Composable
fun MainScreen(navController: NavHostController,viewModel: MainViewModel) {
    Navigation(navHostController = navController,viewModel = viewModel)

}

@ExperimentalPermissionsApi
@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MainScreen(rememberNavController(), viewModel())
}