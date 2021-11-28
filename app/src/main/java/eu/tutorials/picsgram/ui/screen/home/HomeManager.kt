package eu.tutorials.picsgram.ui.screen.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import eu.tutorials.picsgram.model.Post
import eu.tutorials.picsgram.model.User

object HomeManager {


    private val usernames =
        arrayListOf("Steph", "Chris", "John", "Maria",
            "Lina", "Mike", "Eva", "Jose", "Gabriel","Steven")
    private val captions = arrayListOf("Introducing Chromecast beach",
        "This is an independently produced short film",
        "The only place to watch them is by subscribing to The Smoking Tire",
        "Product was realized with crowd-funding by users","Balloon Launch will get some free T-shirts into the hands of our viewers.",
    "Target was to improve and test a complete open and free pipeline for visual effects in film",
    "Will it beat the Mazdaspeed3's standard-setting lap time? Watch and see...",
    "The only place to watch them is by subscribing to The Smoking Tire",
        "Product was realized with crowd-funding by users","This is an independently produced short film")


    private val _posts = mutableStateOf<List<Post>>(listOf())
    val posts: State<List<Post>>
    get() = _posts

     fun displayPosts() {
        val posts = ArrayList<Post>()
        (0..9).forEach { index ->
            val post = Post(
                image = "https://picsum.photos/400/300?$index",
                user = User(
                    name = usernames[index],
                    username = usernames[index],
                    image = "https://source.unsplash.com/random/${index + 1}.jpg"
                ),
                captions = captions[index],
                postedAt = "30 Minutes Ago"
            )
            posts.add(post)
        }

        this._posts.value = posts
    }
}