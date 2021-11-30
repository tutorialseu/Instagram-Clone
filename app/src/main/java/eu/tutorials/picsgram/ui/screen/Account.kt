package eu.tutorials.picsgram.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Logout
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.skydoves.landscapist.coil.CoilImage
import eu.tutorials.picsgram.Manager
import eu.tutorials.picsgram.model.User

/**Todo 1: create an Account file and create AccountDetail composable
 * In AccountDetail parenthesis we create a User variable
 */
@Composable
fun AccountDetail(user: User) {
    /*Todo 2: Add a Column as the parent element and set modifier to fillMaxWidth
    with 16dp of padding */
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        /*Todo 3: In the Column we add a Text and set text to username,modifier to fillMaxWidth,
            textAlign to center and fontWeight to bold*/
        Text(
            text = user.username,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold
        )
        //Todo 4: Below the Text we add a Row and set its modifier to fillMaxWidth and set horizontalArrangement to SpaceBetween
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            /*Todo 5: We add Column and set the profile picture and fullName vertically together
            *  For the profile Picture we set a Box and add a Modifier with size of 100dp, background
            * color of lightGray and shape of CircleShape then set clip to the shape
            * In the box we add a CoilImage and set imageModel to user.image, contentDescription to null
            * and modifier to fillMaxSize
            * Below the Box we add a Text and set text to user.name, fontWeight to bold, textAlign to center
            * and modifier width set to 100 with padding top of 8dp
            * */
            Column {
                Box(
                    modifier = Modifier
                        .size(100.dp)
                        .background(color = Color.LightGray, shape = CircleShape)
                        .clip(CircleShape)
                ) {
                    CoilImage(
                        imageModel = user.image,
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize()
                    )
                }

                Text(
                    text = user.name,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(top = 8.dp)
                )
            }
            //Todo 6: We add another Column within the row for profile stats and Logout Button and set horizontalAlignment to CenterHorizontally
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                //Todo 8: we add a Spacer with a height of 20dp just to push the next element down by 20dp
                Spacer(modifier = Modifier.height(20.dp))
                //Todo 9: We a a Row and modifier to fillMaxWidth then add a horizontalArrangement to SpaceAround
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    /*Todo 10: we add the first AccountStats with count value set to the size of the posts
                    * and label set to Posts
                    * We add a second AccountStats with count set 20 and label set to Stories
                    * We add the third AccountStats with count set to 30 and label set to Following
                    * */
                    AccountStats(count = Manager.posts.value.size, label = "Posts")
                    AccountStats(count = 20, label = "Stories")
                    AccountStats(count = 30, label = "Following")
                }

              /*Todo 11 we add a Row for the Logout text and Icon and set modifier to fillMaxWidth and padding top to 16dp
              then set a horizontal Arrangement to Center
               */
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    /*Todo 12 Within the Row we add a Text and set text to logout, add a modifier and set padding top, bottom and end
                    * to 8dp then set color to red
                    * Below Text we add an Icon and set imageVector to Logout, contentDescription to Logout icon, tint color to Red
                    * then add a Modifier and set padding top, bottom and end to 8dp
                    * */
                    Text(
                        text = "Logout",
                        modifier = Modifier.padding(top = 8.dp,bottom = 8.dp,end = 8.dp),
                        color = Color.Red
                    )
                    Icon(
                        imageVector = Icons.Default.Logout,
                        contentDescription = "Logout",
                        tint = Color.Red,
                        modifier = Modifier.padding(top = 8.dp,bottom = 8.dp,end = 8.dp)
                    )
                }
            }

        }
        /*Todo 14: We add a Button for editing profile Details with modifier set to fillMaxWidth and padding top to 16dp
        Then we add a Text as the content with text set Edit Profile
         */
        Button(
            onClick = { },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        ) {
            Text(text = "Edit Profile")
        }

    }
}


/** Todo 7: We need to create a reusable component for the stats with a count and label parameter
 * Then we add a Column and in it we add a Text with text set to count and aligned with modifier
 * to centerHorizontally. Next we add the second Text for the label with fontWeight set to Bold
 */
@Composable
fun AccountStats(count: Int, label: String) {
    Column {
        Text(text = "$count", modifier = Modifier.align(Alignment.CenterHorizontally))
        Text(text = label, fontWeight = FontWeight.Bold)
    }
}


//Todo 13: We add a Preview function for the AccountDetail
@Preview(showBackground = true)
@Composable
fun AccountDetailPreview() {
    AccountDetail(user = User("Name", "Username", ""))
}