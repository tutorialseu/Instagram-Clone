package eu.tutorials.picsgram.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import eu.tutorials.picsgram.R
import eu.tutorials.picsgram.ui.components.UserTextField

/**Todo 1: create a screen package and create a login file in it
 * create a Login composable with a modifier parameter that we will use for every other element
 */
@Composable
fun Login(modifier: Modifier = Modifier) {
    //Todo 11: we create a state variable for the username, password and visibility icon toggle
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
    //end
    //Todo 18: create a scrollable state
    val scrollState = rememberScrollState()

    /*Todo 2: add a Column as the parent layout with a modifier to fillMaxSize ie height and width
      Then a vertical padding of 16dp ie both top and bottom space
     */
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(vertical = 16.dp)
    ) {
        /*Todo 4: Add a Row for language selection and set to fillMaxWidth
         with a horizontalArrangement to Center
         Add a Text with text set to English
         An Icon set to KeyboardArrowDown
         */
        Row(
            modifier = modifier
                .fillMaxWidth()
                    //Todo 7: Add weight for the language drop down
                    //start
                .weight(1.0f),
                   //end
            horizontalArrangement = Arrangement.Center
        ) {
            Text(text = "English (United States)")
            Icon(imageVector = Icons.Outlined.KeyboardArrowDown, contentDescription = "")
        }

        /*Todo 5:Add a column for the next section of the UI
        so we can group them together and set appropriate space between
        the Instagram image and the language drop down
        We set the width to fillMaxWidth, a horizontal padding of 16.dp
        and weight of 5.0f
        */
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                    //Todo 19:add vertical scrolling
                    //start
                .verticalScroll(scrollState)
                    //end
                .weight(9.0f)
        ) {
            //Todo 6: add an Image and set the instagram drawable to fillMaxWidth
            Image(
                painter = painterResource(id = R.drawable.picsgram), contentDescription = "",
                modifier = modifier
                    .fillMaxWidth()
            )
            /*Todo 12: We add the first reusable element we created for the username,set fieldState
               to usernameState value, in onfieldChange we get the string and
               set the usernameState and then set a placeholder
             */
            UserTextField(
                fieldState = usernameState.value,
                onFieldChange = { usernameState.value = it },
                placeholder = "email",
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
            )

            /*Todo 13: add the reusable element again this time for the password
              set the fieldState to passwordState,in onfieldChange we the value from the field
              and set to passwordState, for passwordToggle we set an IconButton
              and in the onCLick turn toggle state to true or false, now for the Icon
              we check if the togglestate is true we turn on visibility else we turn off visibility
              And then for password transformation we set it none when togglestate is true
              and to password transformation when its false
              */
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

            /*
              Todo 14: we add a Button for Login, the onclick button is not implementedd yet
              we se modifier to fillMaxWidth with a top padding of 16dp.
              Now we only want the button to be enabled when the fields are not empty just like on instagram
              we get the state for each field created above and check if both is not empty then enable the button
             Then we set the text to Login and add a vertical padding
             */
            Button(
                onClick = { },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                enabled = usernameState.value.isNotEmpty() && passwordState.value.isNotEmpty()
            ) {
                Text(text = "Login", modifier = modifier.padding(vertical = 8.dp))
            }


        }

        //Todo 16: We set a line using  a Divider and add a top padding of 48dp
        Divider(modifier = modifier.padding(top = 48.dp))

        /* Todo 17: We add a Row with two Text for new account SignUp
        add a modifier with fillMaxWidth and top padding of 16.dp with horizontalArrangement of Center
         */
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

//Todo 8 we add a preview for the Login
@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    Login()
}