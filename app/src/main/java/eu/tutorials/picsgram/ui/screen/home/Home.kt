package eu.tutorials.picsgram.ui.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement.SpaceBetween
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Apps
import androidx.compose.material.icons.rounded.AddCircle
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import eu.tutorials.picsgram.R
import eu.tutorials.picsgram.model.CreateOptions

@Composable
fun Home() {
   Scaffold(topBar = {
        TopBar()}) {
       Column {
           Stories()
           //Todo 21 add PostFeed to Home UI
           PostFeed()
       }

    }
}

@Composable
fun TopBar() {
    val items = listOf(CreateOptions("Post", Icons.Default.Apps),
        CreateOptions("Story", Icons.Rounded.AddCircle)
    )
    var menuExpanded by remember { mutableStateOf(false) }

    TopAppBar(backgroundColor = Color.White,
        title =
    {
        Image(
            painter = painterResource(id = R.drawable.picsgram),
            contentDescription = "PicsGram",
            modifier = Modifier.height(40.dp)
        )},actions = {
            IconButton(onClick = {
                menuExpanded = true
            }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_add),
                    contentDescription = "Create",
                    tint = Color.Black
                )}

            DropdownMenu(
                expanded = menuExpanded,
                onDismissRequest = {
                    menuExpanded = false
                },
            ) {

                items.forEach {
                    DropdownMenuItem(onClick = {
                        menuExpanded = false
                    },
                        contentPadding = PaddingValues(vertical = 8.dp)) {
                        Column {
                            Row(modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 8.dp),
                                horizontalArrangement = SpaceBetween) {
                                Text(text = it.name)
                                Icon(imageVector = it.icon, contentDescription = it.name)
                            }
                        }
                    }
                }
            }
            })
}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
    Home()
}