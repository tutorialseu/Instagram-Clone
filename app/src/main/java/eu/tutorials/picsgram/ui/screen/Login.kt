package eu.tutorials.picsgram.ui.screen

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Facebook
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material.icons.outlined.KeyboardArrowDown
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import eu.tutorials.picsgram.R
import eu.tutorials.picsgram.Resource
import eu.tutorials.picsgram.ui.components.UserTextField
import eu.tutorials.picsgram.ui.screen.main.Navigation
import eu.tutorials.picsgram.ui.viewmodel.MainViewModel

@Composable
fun Login(modifier: Modifier = Modifier,navController:
NavController,scrollState: ScrollState,viewModel: MainViewModel
) {

    val usernameState = remember {
        mutableStateOf("")
    }
    val passwordState = remember {
        mutableStateOf("")
    }
    val toggleState = remember {
        mutableStateOf(false)
    }
    val context = LocalContext.current
    val loading by viewModel.isLoading.collectAsState()
    val error by viewModel.isError.collectAsState()
    val token = viewModel.prefToken().collectAsState().value
    if (token != ""){
        Log.d("toke","not $token")
        navController.navigate("profile"){
            launchSingleTop = true
            popUpTo("login"){
                inclusive = true
            }
        }
    }
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(vertical = 16.dp)
    ) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .verticalScroll(scrollState)
                .weight(5.0f)
        ) {
            Image(
                painter = painterResource(id = R.drawable.picsgram), contentDescription = "",
                modifier = modifier
                    .fillMaxWidth()
            )
            UserTextField(
                fieldState = usernameState.value,
                onFieldChange = { usernameState.value = it },
                placeholder = "Email",
                label = { Text(text = "Enter Email")}
            )

            UserTextField(
                fieldState = passwordState.value,
                onFieldChange = { passwordState.value = it },
                placeholder = "Password",
                label = { Text(
                    text = "Enter Password"
                )},
                passwordToggle = {
                    IconButton(onClick = { toggleState.value = !toggleState.value }) {
                        Icon(
                            imageVector = if (toggleState.value) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                            contentDescription = ""
                        )
                    }
                },
                passwordTransformation = if (toggleState.value) VisualTransformation.None else PasswordVisualTransformation()
            )

            Button(
                onClick = {
                    viewModel.loginUser(username = usernameState.value,password = passwordState.value)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                enabled = usernameState.value.isNotEmpty() && passwordState.value.isNotEmpty()
            ) {
                Text(text = "Login", modifier = modifier.padding(vertical = 8.dp))
            }

        }
        Divider(modifier = modifier.padding(top = 48.dp))
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(text = "Don't have an account? ")
            Text(text = "Sign Up", fontWeight = FontWeight.Bold,
                modifier = modifier.clickable {
                   navController.navigate("signup"){
                        launchSingleTop = true
                        popUpTo("login"){
                            inclusive = true
                        }
                    }
                })
        }
        val userToken = viewModel.userToken.collectAsState()
        val user = userToken.value?.data
        when(userToken.value){
            is Resource.Success->{
                if (user != null) {
                    viewModel.saveEmail(user.userName)
                    viewModel.saveToken(user.access_token)
                }
                navController.navigate("profile"){
                    launchSingleTop = true
                    popUpTo("login"){
                        inclusive = true
                    }
                }
            }

            is Resource.Loading->{

            }
        }
        when {
            error-> {
                Toast.makeText(context, "An error has occurred", Toast.LENGTH_LONG).show()
                Log.d("token", "${userToken.value?.message}")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginPrev() {
    Login(navController = rememberNavController(),scrollState = rememberScrollState(),viewModel = viewModel())
}