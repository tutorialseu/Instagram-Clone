package eu.tutorials.picsgram.ui.screen

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class MainViewModel : ViewModel() {

    val usernameState = MutableStateFlow("User Name")
    val fullNameState = MutableStateFlow("Full Name")

}