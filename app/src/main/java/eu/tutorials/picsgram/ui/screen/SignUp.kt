package eu.tutorials.picsgram.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import eu.tutorials.picsgram.R
import eu.tutorials.picsgram.ui.components.UserTextField
import eu.tutorials.picsgram.ui.screen.main.Navigation


@Composable
fun SignUp(modifier: Modifier = Modifier, dp: Dp = 16.dp,navController: NavController) {
    val usernameState = remember {
        mutableStateOf("")
    }
    val passwordState = remember {
        mutableStateOf("")
    }
    val toggleState = remember {
        mutableStateOf(false)
    }
    val nameState = remember {
        mutableStateOf("")
    }
    val emailState = remember {
        mutableStateOf("")
    }
    val enableButton = usernameState.value.isNotEmpty() && passwordState.value.isNotEmpty()
            &&nameState.value.isNotEmpty() && emailState.value.isNotEmpty()
    Column(modifier = modifier
        .fillMaxSize()
        .padding(horizontal = dp)) {
        Image(
            painter = painterResource(id = R.drawable.picsgram), contentDescription = "",
            modifier = modifier
                .fillMaxWidth()
        )
        UserTextField(fieldState = nameState.value, onFieldChange = {
            nameState.value = it
        }, placeholder = "Full name")

        UserTextField(fieldState = emailState.value, onFieldChange = {
            emailState.value = it
        }, placeholder = "Email",
           keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email))
        UserTextField(fieldState = usernameState.value, onFieldChange = {
            usernameState.value = it
        }, placeholder = "Username")
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
            passwordTransformation = if (toggleState.value) VisualTransformation.None else PasswordVisualTransformation()
        )
Button(
            onClick = { },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = dp),
            enabled = enableButton
        ) {
            Text(text = "Sign Up", modifier = modifier.padding(vertical = 8.dp))
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
                   navController.navigate("login"){
                        launchSingleTop = true
                    }
                })
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SignUpPreview() {
    SignUp(navController = rememberNavController())
}