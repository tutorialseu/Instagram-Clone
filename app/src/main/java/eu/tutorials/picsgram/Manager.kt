package eu.tutorials.picsgram

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import eu.tutorials.picsgram.model.Activity
import eu.tutorials.picsgram.model.Post
import eu.tutorials.picsgram.model.User


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

    private val gridUsernames =
        arrayListOf("Steph", "Chris", "John", "Maria",
            "Lina", "Mike", "Eva", "Jose", "Gabriel","Steven","James","Lidia","Ben",
        "Ted","Rose","Jen","Galaxy","Crystal","Diamond","Laura")

    private val _gridPosts = mutableStateOf<List<Post>>(listOf())
    val gridPosts:State<List<Post>>
        get() = _gridPosts

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

                captions = "",
                postedAt = "30 Minutes Ago"
            )
            posts.add(post)

        }

        _gridPosts.value = ArrayList(posts.map { it.copy() })
    }

    //Todo 2: create a setter and getter for the activity post list
    private val _activityPost  = mutableStateOf<List<Activity>>(listOf())
    val activityPost:State<List<Activity>>
    get() = _activityPost

    //Todo 3: create a function to generate the list
    fun displayActivity(){
        //Todo 4: we create a post ArrayList, loop through 10 indexes and add a Post to each
        val posts = ArrayList<Activity>()
        (0..9).forEach { index ->
            val post = Post(
                image = "https://picsum.photos/100/100?$index",
                user = User(
                    name = usernames[index],
                    username = usernames[index],
                    image = "https://source.unsplash.com/random/${index + 1}.jpg"
                ),

                captions = "",
                postedAt = "30 Minutes Ago"
            )
            //Todo 5: Here we add posts under a topic creating 3 topics
            when {
               ( index < 3 ) -> {
                posts.add(Activity("Technology", post = post))
            }
                ( index < 6 ) -> {
                    posts.add(Activity("Startup", post = post))
                }
                ( index < 10 ) -> {
                    posts.add(Activity("Vacation", post = post))
                }
            }
        }
        //Todo 6: assign posts as value to activity post
        _activityPost.value = posts
    }

}