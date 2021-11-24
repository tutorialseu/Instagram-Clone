package eu.tutorials.picsgram.ui.screen

import androidx.compose.foundation.Image
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
import eu.tutorials.picsgram.R
import eu.tutorials.picsgram.ui.components.UserTextField

/**Todo 1: create the SignUp file and then a composable with
 * [modifier] variable for defining each elements variable and [dp]
 * with a value of 16
  */
@Composable
fun SignUp(modifier: Modifier = Modifier, dp: Dp = 16.dp) {
    // Todo 2: create state variable for all fields and a toggle state for hiding and revealing the password characters
    //start
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
    //end

    //Todo 3: create a variable for the signup enabled state which is when all the fields has atleas one character
    val enableButton = usernameState.value.isNotEmpty() && passwordState.value.isNotEmpty()
            &&nameState.value.isNotEmpty() && emailState.value.isNotEmpty()
    //Todo 4: Add a Column as the parent layout and set modifier to fill max size with a horizontal padding of 16dp
    Column(modifier = modifier.fillMaxSize().padding(horizontal = dp)) {
        //Todo 5: add an Image for displaying the Logo with modifier set to fillMaxWidth
        Image(
            painter = painterResource(id = R.drawable.picsgram), contentDescription = "",
            modifier = modifier
                .fillMaxWidth()
        )
        //Todo 6: Using the input component we previously created we add the input fields and set each field state to it,
        //the placeholder and onFieldChange for when the input changes
        //start
        UserTextField(fieldState = nameState.value, onFieldChange = {
            nameState.value = it
        }, placeholder = "Full name")

        UserTextField(fieldState = emailState.value, onFieldChange = {
            emailState.value = it
        }, placeholder = "Email",
            //Todo 7: for the email field we set the keyboard type to email so it shows the @ symbol
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email))
        UserTextField(fieldState = usernameState.value, onFieldChange = {
            usernameState.value = it
        }, placeholder = "Username")
        UserTextField(
            fieldState = passwordState.value,
            onFieldChange = { passwordState.value = it },
            placeholder = "Password",
            //Todo 8: The password field uses a toggle icon to hide or reveal the password characters
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
//end
        //Todo 10: add a Signup Button which is enabled when the fields are not empty
        Button(
            onClick = { },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = dp),
            enabled = enableButton
        ) {
            Text(text = "Sign Up", modifier = modifier.padding(vertical = 8.dp))
        }

        //Todo 11: set a divider to add a line below the Button
        Divider(modifier = modifier.padding(top = 48.dp))
        //Todo 12:A row with two Text side by side for a user with an existing account
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(top = dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(text = "Already Have An Account? ")
            Text(text = "Login", fontWeight = FontWeight.Bold)
        }
    }
}

//Todo 9: add a preview function
@Preview(showBackground = true)
@Composable
fun SignUpPreview() {
    SignUp()
}