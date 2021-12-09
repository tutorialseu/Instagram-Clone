package eu.tutorials.picsgram.ui.screen

import android.Manifest
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Logout
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberPermissionState
import com.skydoves.landscapist.coil.CoilImage
import eu.tutorials.picsgram.R
import eu.tutorials.picsgram.Resource
import eu.tutorials.picsgram.Utils.base64ToByteCode
import eu.tutorials.picsgram.Utils.bitmapToBase64
import eu.tutorials.picsgram.model.LoginUserResponse
import eu.tutorials.picsgram.ui.viewmodel.MainViewModel
import kotlinx.coroutines.flow.collect

@ExperimentalPermissionsApi
@Composable
fun ProfileScreen(viewModel: MainViewModel,navController: NavController) {
    var imageUri by remember {
        mutableStateOf<Uri?>(null)
    }
    val context = LocalContext.current
    var bitmap: Bitmap? = null

    var userNameState by remember {
        mutableStateOf("")
    }

    var keyState by remember {
        mutableStateOf("")
    }

    val token = viewModel.prefToken().collectAsState().value
    val email = viewModel.prefEmail().collectAsState().value
    userNameState = email
    keyState = token
    viewModel.getUserProfile(username = userNameState, key = "Bearer ${keyState}")
    Log.d("token", "${userNameState} and $keyState")

    val loading by viewModel.isLoading.collectAsState()
    val error by viewModel.isError.collectAsState()

    val permissionsState = rememberPermissionState(
        permission = Manifest.permission.READ_EXTERNAL_STORAGE
    )
    val launcher = rememberLauncherForActivityResult(
        contract =
        ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        imageUri = uri
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
                imageUri?.let {
                    bitmap = if (Build.VERSION.SDK_INT < 28) {
                        MediaStore.Images
                            .Media.getBitmap(context.contentResolver, it)

                    } else {
                        val source = ImageDecoder
                            .createSource(context.contentResolver, it)
                        ImageDecoder.decodeBitmap(source)
                    }
                }
                when {
                    loading -> {

                    }
                    error -> {

                    }

                    !loading -> {
                        viewModel.getUserProfile(
                            username = userNameState,
                            key = "Bearer ${keyState}"
                        )
                    }
                }
                val imageResult = viewModel.userImage.collectAsState().value
                when (imageResult) {
                    is Resource.Loading -> {

                    }
                    is Resource.Error -> {

                    }

                    is Resource.Success -> {
                        if (!imageResult.data.isNullOrEmpty()) {
                            imageResult.data.base64ToByteCode().let {
                                Image(
                                    bitmap = it.asImageBitmap(),
                                    contentDescription = null,
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
                            }
                        }else{
                            Image(
                                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                                contentDescription = null,
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
                        }
                    }
                }
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 18.dp)
                ) {
                    Text(
                        text = userNameState,modifier = Modifier.padding(top = 10.dp)
                    )

                    IconButton(onClick = {
                        viewModel.clearUserToken()
                        navController.navigate("login") {
                            launchSingleTop = true
                        }
                    }) {
                        Icon(imageVector = Icons.Default.Logout, contentDescription = null,tint = Color.Red)
                    }
                }

                Button(
                    onClick = {
                        if (permissionsState.hasPermission) {
                            launcher.launch("image/*")
                        } else {
                            permissionsState.launchPermissionRequest()
                        }
                    },
                    modifier = Modifier
                        .padding(horizontal = 8.dp, vertical = 32.dp)
                        .fillMaxWidth()

                ) {
                    Text(text = "Edit Profile")
                }

            }
        }
    }
    bitmap?.let { btm ->
        val imageUrl = btm.bitmapToBase64()
        viewModel.addUserImage(
            username = userNameState,
            imageUrl = imageUrl,
            key = "Bearer $keyState"
        )
    }
}

@ExperimentalPermissionsApi
@Preview(showBackground = true)
@Composable
fun ProfilePreview() {
    ProfileScreen(viewModel(), rememberNavController())
}