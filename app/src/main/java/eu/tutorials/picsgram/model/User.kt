package eu.tutorials.picsgram.model

//Todo 3: For each post there is a user so we
// create a User object with name, username and image fields
data class User(
  val name: String,
  val username: String,
  val image: String
)
