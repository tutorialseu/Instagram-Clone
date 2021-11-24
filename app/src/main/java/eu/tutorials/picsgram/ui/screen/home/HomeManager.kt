package eu.tutorials.picsgram.ui.screen.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import eu.tutorials.picsgram.model.Story
import eu.tutorials.picsgram.model.User

object HomeManager {
    private val currentUser = User("Jane","Jane Doe","https://source.unsplash.com/woman/200x200")
    private val names = arrayOf("Jane","Chris","Mac","John","Sofia","Mike","Grace","James","Linda","Amelia")
    private val storyList = mutableStateOf<List<Story>>(listOf())
        val postStory:State<List<Story>>
          get() = storyList

    private fun getStories(){
        val stories = mutableListOf<Story>()

     stories.add(Story(currentUser.image,"Your Story"))

        (0..9).forEach { index ->
            val story = Story(
                image = "https://source.unsplash.com/random/${index + 1}.jpg",
                name = names[index]
            )
            stories.add(story)
        }

        storyList.value = stories
    }


    init {
        getStories()
    }




}