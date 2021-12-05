package eu.tutorials.picsgram.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material.icons.outlined.KeyboardArrowDown
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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import eu.tutorials.picsgram.R
import eu.tutorials.picsgram.ui.components.UserTextField


@Composable
fun Login(modifier: Modifier = Modifier,
    //Todo 6: Add NavController as parameter
          navController: NavController) {
    val usernameState = remember {
        mutableStateOf("")
    }
    val passwordState = remember {
        mutableStateOf("")
    }
    val toggleState = remember {
        mutableStateOf(false)
    }
    val scrollState = rememberScrollState()
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(vertical = 16.dp)
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .weight(1.0f),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(text = "English (United States)")
            Icon(imageVector = Icons.Outlined.KeyboardArrowDown, contentDescription = "")
        }

        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .verticalScroll(scrollState)
                .weight(9.0f)
        ) {
            Image(
                painter = painterResource(id = R.drawable.picsgram), contentDescription = "",
                modifier = modifier
                    .fillMaxWidth()
            )

            UserTextField(
                fieldState = usernameState.value,
                onFieldChange = { usernameState.value = it },
                placeholder = "email",
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
            )

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
                    .padding(top = 16.dp),
                enabled = usernameState.value.isNotEmpty() && passwordState.value.isNotEmpty()
            ) {
                Text(text = "Login", modifier = modifier.padding(vertical = 8.dp))
            }

            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp), horizontalArrangement = Arrangement.Center
            ) {
                Text(text = "forgot your login details? ")
                Text(text = "Get help Signing in.", fontWeight = FontWeight.Bold)
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
                //Todo 7: Make the sign up text clickable using modifier and calling the clickable method
                modifier = modifier.clickable {
                /*Todo 8: using navController we call navigate method and pass in signup
                set launchSingleTop to true so we won't have a duplicate route
                set popUpTo to login and inclusive set to true so we don't have any route left at the back stack
                 */
                navController.navigate("signup"){
                    launchSingleTop = true
                    popUpTo("login"){
                        inclusive = true
                    }
                }
            })
        }
    }
}


@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    //Todo 9: pass rememberNavController as argument
    Login(navController = rememberNavController())
}