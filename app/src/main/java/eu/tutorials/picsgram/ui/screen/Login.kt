package eu.tutorials.picsgram.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Facebook
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material.icons.outlined.KeyboardArrowDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import eu.tutorials.picsgram.R
import eu.tutorials.picsgram.ui.components.UserTextField

@Composable
fun Login(modifier: Modifier = Modifier,navController: NavController) {
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
                .weight(1.0f), horizontalArrangement = Arrangement.Center
        ) {
            Text(text = "English (United States)")
            Icon(imageVector = Icons.Outlined.KeyboardArrowDown, contentDescription = "")
        }

        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .scrollable(scrollState, Orientation.Vertical)
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
                placeholder = "Phone number, email or username"
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
                onClick = {
                 navController.navigate("main")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                enabled = usernameState.value.isNotEmpty() && passwordState.value.isNotEmpty(),
               colors = ButtonDefaults.buttonColors(backgroundColor = Color.Blue,contentColor = Color.White)) {
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
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp)
            ) {
                Divider(
                    modifier = modifier
                        .weight(5.0f)
                        .padding(top = 12.dp)
                )
                Text(text = " OR ")
                Divider(
                    modifier = modifier
                        .weight(5.0f)
                        .padding(top = 12.dp)
                )
            }
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Facebook,
                    contentDescription = "",
                    tint = Color.Blue
                )
                Text(text = " Login With Facebook ")
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
            Text(text = "Sign Up", fontWeight = FontWeight.Bold)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    Login(navController = rememberNavController())
}