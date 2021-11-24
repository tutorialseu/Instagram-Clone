package eu.tutorials.picsgram.model

data class Post(
    val id: Int,
    val image: String,
    val user: User,
    val timeStamp: Long
)

data class Story(
    val image: String,
    val name: String
)