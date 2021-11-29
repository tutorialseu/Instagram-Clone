package eu.tutorials.picsgram.ui.screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.skydoves.landscapist.coil.CoilImage
import eu.tutorials.picsgram.Manager

@ExperimentalFoundationApi
@Composable
fun Search() {
    //Todo 8: We create a remember state query value
    val query = remember {
        mutableStateOf("")}
    Manager.displayGrid()
    //Todo 5: Add a Column then set the SearchBar and LazyVerticalGrid within it
    Column {
        //Todo 9:add query.value as value argument and a lambda block with query.value passed into it
        // and returned String from the lambda assigned to it
        SearchBar(query.value) {
            query.value = it
        }
        LazyVerticalGrid(cells = GridCells.Adaptive(minSize = 128.dp)) {
            val posts = Manager.gridPosts
            items(posts.value) {
                CoilImage(imageModel = it.image)
            }
        }
    }
}

//Todo 1: Create SearchBar composable
@Composable
fun SearchBar(
    //Todo 6: we add a String parameter and a lambda method with String parameter that returns nothing
    value:String,onValueChange:(String)->Unit={}) {
    /*Todo 2: Add a Card with RoundedCornerShape set to 40 percent,
    use modifier to set width to fillMaxWidth and padding to 8dp,
    Set elevation to 6dp
     */
    Card(
       shape = RoundedCornerShape(40), modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),elevation = 6.dp
    ) {
        /*Todo 3:Add a TextField with value set to empty string and onValueChange set to empty lambda,
        add a label and assign a Text with text set to search and color set to lightGray,
        set leadingIcon and assign IconButton with Icon set to Search, empty contentDescription and tint color set to Black,
        set colors and edit with textFieldColors, textColor edits the entered text,backgroundColor set to lighter gray.
        To create a custom color code we use the ARGB format. we change the cursorColor, unfocusedIndicator and focusedIndicator color
         */
        //Todo 7: We change set the value parameter as value and onValueChanged parameter added to the onValueChanged block
            TextField(value = value, onValueChange = {
              onValueChange(it)
            }, label = {
                Text(text = "Search", color = Color.LightGray)
            }, leadingIcon = {
                IconButton(onClick = { }) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "",
                        tint = Color.Black
                    )
                }
            },colors = TextFieldDefaults.textFieldColors(
                textColor = Color.Black,
                backgroundColor =  Color(0xFFFAFAFA),
                cursorColor = Color.Black,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,)
            )
        }}

//Todo 4: Add a Preview function for the SearchBar
@Preview(showBackground = true)
@Composable
fun SearchBarPreview() {
    SearchBar("")
}