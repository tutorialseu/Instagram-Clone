package eu.tutorials.picsgram.ui.screen.account

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
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState
import com.skydoves.landscapist.coil.CoilImage
import eu.tutorials.picsgram.Manager
import eu.tutorials.picsgram.model.TabItem
import eu.tutorials.picsgram.model.User


//Todo 3: Create an Account Composable and set a Column as the parent element
@Composable
fun Account() {
    Column {
        //Todo 4: Add AccountDetail and pass in user value from the Manager class
        AccountDetail(user = Manager.user.value)
    }
}



@Composable
fun AccountDetail(user: User) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {

        Text(
            text = user.username,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

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
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Spacer(modifier = Modifier.height(20.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {

                    AccountStats(count = Manager.posts.value.size, label = "Posts")
                    AccountStats(count = 20, label = "Stories")
                    AccountStats(count = 30, label = "Following")
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp),
                    horizontalArrangement = Arrangement.Center
                ) {

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


@Composable
fun AccountStats(count: Int, label: String) {
    Column {
        Text(text = "$count", modifier = Modifier.align(Alignment.CenterHorizontally))
        Text(text = label, fontWeight = FontWeight.Bold)
    }
}


@ExperimentalPagerApi
@Preview(showBackground = true)
@Composable
fun AccountDetailPreview() {
    Account()
}