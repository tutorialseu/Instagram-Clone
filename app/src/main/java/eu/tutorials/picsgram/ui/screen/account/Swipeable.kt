package eu.tutorials.picsgram.ui.screen.account

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

/**Todo 8: create a composable with [tabItems] and [pagerState] parameter
 * tabItems is the list of TabItem while pagerState is a state item that can be used to observe
 * the pager scrolling state.
 * PagerState is an experimentalPagerApi so we add the experimental annotation
 * */

@ExperimentalPagerApi
@Composable
fun Swipeable(tabItems: List<TabItem>, pagerState: PagerState) {

    /*Todo 12:
        We create a rememberCoroutineScope variable for the animateScrollToPage */
    val scope = rememberCoroutineScope()

    /*Todo 9: We add a TabRow to show the different items and set its properties;
    *selectedTabIndex to pagerState.currentPage, backgroundColor to White, indicator to its default
    * indicator with pagerTabIndicatorOffset added to it and its arguments set as pagerState and tabPositions.
    * pagerTabIndicatorOffset will sync up the TabRow indicator with the pager
    * */
    TabRow(selectedTabIndex = pagerState.currentPage,
    backgroundColor = Color.White,
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                Modifier.pagerTabIndicatorOffset(pagerState, tabPositions),height = 5.dp
            )
        }) {
        /*Todo 10: We set a Tab  as the content for the TabRow. First is to loop
        *  through the tabItems and then add a Tab and set icon to the icon from the list and icon
        * contentDescription set as the title for each tabItem with tint color set to purple_500
        * text is set to the title from the list
        *
        * selected is set to true when pagerState.currentPage equal the index */
        tabItems.forEachIndexed { index, tab ->
            Tab(
                icon = { Icon(imageVector = tab.icon, contentDescription = tab.title,tint = colorResource(
                    id = R.color.purple_500
                ))},
                text = { Text(tab.title) },
                modifier = Modifier.height(60.dp),
                selected = pagerState.currentPage == index,
                onClick = {
                    //Todo 13: we launch a scope and move the implementation into it
                    scope.launch {
                        /*Todo 11 we call animateScrollToPage and pass in index for the clicked tab which
                        * will also get the page for that tab. but this method is a suspend function and needs to be
                        * in a coroutine scope
                        * */
                        pagerState.animateScrollToPage(index)
                    }
                },
            )
        }
    }
    /*Todo 14: Then we add the HorizontalPager and set the count to tabItems.size and state to pagerState
    *The tab and the pager uses the same tabItems and pagerState which will sync them together
     */
    HorizontalPager(
        count = tabItems.size,
        state = pagerState,
    ) {

    }

}

//Todo 14: Now we add a preview Function for the Swipeable and the Experimental annotation
@ExperimentalPagerApi
@Preview(showBackground = true)
@Composable
fun SwipeablePreview() {
    val tabs = listOf(TabItem.Posts,TabItem.Stories)
    Swipeable(tabItems = tabs, pagerState = rememberPagerState() )
}