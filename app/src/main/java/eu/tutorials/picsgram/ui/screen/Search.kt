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
    val query = remember {
        mutableStateOf("")}
    Manager.displayGrid()
    Column {
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


@Composable
fun SearchBar(
    value:String,onValueChange:(String)->Unit={}) {
    Card(
       shape = RoundedCornerShape(40), modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),elevation = 6.dp
    ) {
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


@Preview(showBackground = true)
@Composable
fun SearchBarPreview() {
    SearchBar("")
}