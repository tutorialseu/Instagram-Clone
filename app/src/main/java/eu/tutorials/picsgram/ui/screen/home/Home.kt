package eu.tutorials.picsgram.ui.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import eu.tutorials.picsgram.R

@Composable
fun Home() {
    Scaffold(topBar = {}) {

    }
}

@Composable
fun TopBar() = TopAppBar(backgroundColor = Color.White) {
    Image(
        painter = painterResource(id = R.drawable.instagram),
        contentDescription = "Instagram",
        modifier = Modifier.height(40.dp)
    )
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
        IconButton(onClick = {  }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_add),
                contentDescription = "Add a Photo",
                tint = Color.Black
            )
        }
        IconButton(onClick = { }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_message),
                contentDescription = "Message",
                tint = Color.Black
            )
        }
    }
}