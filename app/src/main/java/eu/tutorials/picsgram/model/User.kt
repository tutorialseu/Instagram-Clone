package eu.tutorials.picsgram.model

data class RegisterUser(
  val email: String,
  val password: String,
  val confirmPassword: String
)

data class LoginUserResponse(
  val access_token: String="",
  val token_type: String="",
  val expires_in: String="",
  val userName:String=""
)

data class TokenRequest(
  val grant_type:String = "password",
  val username:String,
  val password:String
)