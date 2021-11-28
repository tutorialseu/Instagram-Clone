package eu.tutorials.picsgram

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import eu.tutorials.picsgram.model.Post
import eu.tutorials.picsgram.model.User

//Todo 7: Rename class to Manager and move out of the home package
object Manager {


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

        _posts.value = posts
    }

    //Todo 3: create usernames for the search grid
    private val gridUsernames =
        arrayListOf("Steph", "Chris", "John", "Maria",
            "Lina", "Mike", "Eva", "Jose", "Gabriel","Steven","James","Lidia","Ben",
        "Ted","Rose","Jen","Galaxy","Crystal","Diamond","Laura")

    //Todo 4 create setter and getter for the search post
    //start
    private val _gridPosts = mutableStateOf<List<Post>>(listOf())
    val gridPosts:State<List<Post>>
        get() = _gridPosts
    //end

    //Todo 5: create a function to generate 20 posts for the search feed
    fun displayGrid() {
        val posts = ArrayList<Post>()
        (0..19).forEach { index ->
            val post = Post(
                image = "https://picsum.photos/400/300?$index",
                user = User(
                    name = gridUsernames[index],
                    username = gridUsernames[index],
                    image = "https://source.unsplash.com/random/${index + 1}.jpg"
                ),
                //Todo 6: set caption to empty string, we don't need it for the searchh screen
                captions = "",
                postedAt = "30 Minutes Ago"
            )
            posts.add(post)

        }

        _gridPosts.value = ArrayList(posts.map { it.copy() })
    }
}