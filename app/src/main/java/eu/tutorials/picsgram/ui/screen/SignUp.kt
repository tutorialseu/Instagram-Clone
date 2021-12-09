package eu.tutorials.picsgram.ui.screen

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import eu.tutorials.picsgram.R
import eu.tutorials.picsgram.Resource
import eu.tutorials.picsgram.Utils
import eu.tutorials.picsgram.model.RegisterUser
import eu.tutorials.picsgram.ui.components.UserTextField
import eu.tutorials.picsgram.ui.viewmodel.MainViewModel
import kotlinx.coroutines.delay


@Composable
fun SignUp(
    modifier: Modifier = Modifier, dp: Dp = 16.dp,
    scrollState: ScrollState, navController: NavController, viewModel: MainViewModel
) {
    val passwordState = remember {
        mutableStateOf("")
    }
    val labelState = remember {
        mutableStateOf("Enter Password")
    }
    val toggleState = remember {
        mutableStateOf(false)
    }
    val isError = remember {
        mutableStateOf(false)
    }
    val emailState = remember {
        mutableStateOf("")
    }
    val context = LocalContext.current
    val enableButton = passwordState.value.isNotEmpty()
            && emailState.value.isNotEmpty()

    val loading by viewModel.isLoading.collectAsState()
    val error by viewModel.isError.collectAsState()
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
                fieldState = emailState.value, onFieldChange = {
                    emailState.value = it
                }, placeholder = "Email",
                label = { Text(text = "Enter Email")},
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email))
            UserTextField(
                fieldState = passwordState.value,
                onFieldChange = { passwordState.value = it },
                placeholder = "Password",
                passwordToggle = {
                    IconButton(onClick = { toggleState.value = !toggleState.value }) {
                        Icon(
                            imageVector = if (toggleState.value) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                            contentDescription = ""
                        )
                    }
                },
                passwordTransformation = if (toggleState.value) VisualTransformation.None else
                    PasswordVisualTransformation(),
                isError = isError.value,
                label = { Text(
                    text = labelState.value
                )}
            )
            Button(
                onClick = {
                    isError.value = !Utils.isValid(password = passwordState.value)
                    if (!isError.value){
                        labelState.value = "Enter Password"
                        val registerUser = RegisterUser(email = emailState.value,password = passwordState.value,
                        confirmPassword = passwordState.value)
                        viewModel.registerUser(registerUser = registerUser)
                        when{
                          loading->{

                          }
                            error->{
                                Toast.makeText(context,"An error has occurred",Toast.LENGTH_LONG).show()
                            }
                            else-> {
                                viewModel.loginUser(emailState.value,password = passwordState.value)
                            }
                        }

                    }else{
                        labelState.value = "Password must have at least 6 characters including 1 uppercase,symbol,lower and digit "
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = dp),
                enabled = enableButton
            ) {
                Text(text = "Sign Up", modifier = modifier.padding(vertical = 8.dp))
            }

        }

        Divider(modifier = modifier.padding(top = 48.dp))
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(top = dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(text = "Already Have An Account? ")
            Text(text = "Login", fontWeight = FontWeight.Bold,
                modifier = modifier.clickable {
                    navController.navigate("login") {
                        launchSingleTop = true
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
            is Resource.Error ->{
                Log.d("token","${userToken.value?.message}")
                Toast.makeText(context,userToken.value?.message,Toast.LENGTH_LONG).show()
            }

            is Resource.Loading->{

            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun SignUpPreview() {
    SignUp(
        navController = rememberNavController(), scrollState = rememberScrollState(),
        viewModel = viewModel()
    )
}