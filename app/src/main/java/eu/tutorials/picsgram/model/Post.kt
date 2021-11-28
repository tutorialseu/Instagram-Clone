package eu.tutorials.picsgram.model

//Todo 4: Create a post object with image, user, post and time posted
data class Post( val image: String,
                 val user: User,val captions:String,val postedAt:String)
