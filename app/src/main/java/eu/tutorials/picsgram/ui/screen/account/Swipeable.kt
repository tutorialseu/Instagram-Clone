package eu.tutorials.picsgram.ui.screen.account

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.height
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.*
import eu.tutorials.picsgram.R
import eu.tutorials.picsgram.model.TabItem
import kotlinx.coroutines.launch

//Todo 15 add experimental  foundation annotation, TabItem now needs it
@ExperimentalFoundationApi
@ExperimentalPagerApi
@Composable
fun Swipeable(tabItems: List<TabItem>, pagerState: PagerState) {

    val scope = rememberCoroutineScope()

    TabRow(selectedTabIndex = pagerState.currentPage,
    backgroundColor = Color.White,
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                Modifier.pagerTabIndicatorOffset(pagerState, tabPositions),height = 5.dp
            )
        }) {

        tabItems.forEachIndexed { index, tab ->
            Tab(
                icon = { Icon(imageVector = tab.icon, contentDescription = tab.title,
                tint = colorResource(id = R.color.purple_500)) },
                text = { Text(tab.title) },
                modifier = Modifier.height(60.dp),
                selected = pagerState.currentPage == index,
                onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                },
            )
        }
    }

    HorizontalPager(
        count = tabItems.size,
        state = pagerState,
    ) {page->
     tabItems[page].screen()
    }

}

//Todo 14 add experimental  foundation annotation, TabItem now needs it
@ExperimentalFoundationApi
@ExperimentalPagerApi
@Preview(showBackground = true)
@Composable
fun SwipeablePreview() {
    val tabs = listOf(TabItem.Posts,TabItem.Stories)
    Swipeable(tabItems = tabs, pagerState = rememberPagerState() )
}