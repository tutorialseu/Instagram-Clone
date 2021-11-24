package eu.tutorials.picsgram.ui.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import eu.tutorials.picsgram.R
import eu.tutorials.picsgram.ui.components.StoriesBox

@Composable
fun Home() {
    Scaffold(topBar = { TopBar() }) {
        Column {
            LazyRow() {
                items(HomeManager.postStory.value) {
                  Stories(it.name,it.image)
                }
            }
        }
    }
}


@Composable
fun TopBar() {
    TopAppBar(backgroundColor = Color.White, elevation = 6.dp) {
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
                    painter = painterResource(id = R.drawable.message),
                    contentDescription = "Message",
                    tint = Color.Black
                )
            }
        }
    }
}

@Composable
fun Stories(name:String,image:String) {
    val shape = CircleShape
    Column(modifier = Modifier.padding(8.dp),horizontalAlignment = Alignment.CenterHorizontally) {
    StoriesBox(shape =shape, image =image)

        Text(text = name,textAlign = TextAlign.Center)
    }
}