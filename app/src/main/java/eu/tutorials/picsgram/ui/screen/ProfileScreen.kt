package eu.tutorials.picsgram.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.skydoves.landscapist.coil.CoilImage
import eu.tutorials.picsgram.R

@Composable
fun ProfileScreen(viewModel: MainViewModel) {
    var enableTextState by remember {
        mutableStateOf(false)
    }

    var buttonTextState by remember {
        mutableStateOf("")
    }
    buttonTextState = if (enableTextState) "Save" else "Edit Profile"

    var userNameState by remember {
        mutableStateOf(viewModel.usernameState.value)
    }

    var fullNameState by remember {
        mutableStateOf(viewModel.fullNameState.value)
    }
    Box(modifier = Modifier.fillMaxSize()) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center)
                .padding(horizontal = 32.dp), shape = RoundedCornerShape(4), elevation = 6.dp
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .wrapContentSize()
                    .padding(top = 16.dp)
                    .background(color = Color.White)
            ) {
                CoilImage(
                    imageModel = R.drawable.ic_launcher_background,
                    modifier = Modifier
                        .size(200.dp)
                        .border(
                            shape = CircleShape,
                            width = 1.dp,
                            color = Color.White
                        )
                        .clip(
                            CircleShape
                        )
                        .background(color = Color.LightGray)
                        .clickable(false) {

                        },
                )
                OutlinedTextField(
                    value = userNameState,
                    onValueChange = {
                                    userNameState = it
                    },
                    modifier = Modifier.padding(top = 18.dp),
                    enabled = enableTextState,
                    textStyle = TextStyle(fontSize = 18.sp),
                    label = {
                        Text(text = "Username")
                    }
                )
                OutlinedTextField(
                    value = fullNameState,
                    onValueChange = {
                            fullNameState = it
                    },
                    modifier = Modifier.padding(top = 18.dp),
                    enabled = enableTextState,
                    textStyle = TextStyle(fontSize = 18.sp),
                    label = {
                        Text(text = "Full Name")
                    }
                )
                Button(
                    onClick = {
                        if (fullNameState.isNotEmpty() && userNameState.isNotEmpty()){
                        enableTextState = !enableTextState
                        }
                              if (buttonTextState == "Save"){
                                  //Todo
                              }},
                    modifier = Modifier
                        .padding(horizontal = 8.dp, vertical = 32.dp)
                        .fillMaxWidth()

                ) {
                    Text(text = buttonTextState)
                }

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfilePreview() {
    ProfileScreen(viewModel())
}