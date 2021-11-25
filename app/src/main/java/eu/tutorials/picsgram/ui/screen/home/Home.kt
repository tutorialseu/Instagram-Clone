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

//Todo 1: create the home package then a home file in it with a composable
@Composable
fun Home() {
    //Todo 2: add the scaffold as it has a slot for the topbar and call the tobBar with an empty block
    Scaffold(topBar = {
        //Todo 7: We call the TopBar we created
        TopBar()}) {

    }
}

//Todo 3: We create the topbar as a separate composable
@Composable
fun TopBar() {
    //Todo 12: create a list of each drop down item
    val items = listOf(CreateOptions("Post", Icons.Default.Apps),
        CreateOptions("Story", Icons.Rounded.AddCircle)
    )
    //Todo 9: create a state for expanding the DropDownMenu
    var menuExpanded by remember { mutableStateOf(false) }
    //Todo 4: add the TopAppBar and set background to white
    TopAppBar(backgroundColor = Color.White,
        //Todo 5: we set the title as the Image compose with picsgram image set as drawable and a height of 40dp
        title =
    {
        Image(
            painter = painterResource(id = R.drawable.picsgram),
            contentDescription = "PicsGram",
            modifier = Modifier.height(40.dp)
        )},actions = {
            //Todo 6: we set its actions and assign the icon button with an add icon
            IconButton(onClick = {
                //Todo 10: set the state to true when the icon is clicked
                menuExpanded = true
            }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_add),
                    contentDescription = "Create",
                    tint = Color.Black
                )}
            /*Todo 13: We add the DropDownMenu within the actions block and set its expanded value to menuExpanded state
            so when the icon button is clicked and menuExpanded is set the true the menu is shown
             */
            DropdownMenu(
                expanded = menuExpanded,
                onDismissRequest = {
                    menuExpanded = false
                },
            ) {
                /*Todo 14: We loop through each item and add the DropDownMenuItem and when clicked we
                set menuExpanded to false so the menu can dismiss. Set contentPadding for vertical
                sides to 8dp
               */
                items.forEach {
                    DropdownMenuItem(onClick = {
                        menuExpanded = false
                    },
                        contentPadding = PaddingValues(vertical = 8.dp)) {
                        //Todo 15 The menu item is a Row with a Text and an Icon where we set
                        // the name from the items list created to the Text and image vector toICon
                        Column {
                            Row(modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp),
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

//Todo 8: add a preview function
@Preview(showBackground = true)
@Composable
fun HomePreview() {
    Home()
}