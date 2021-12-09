package eu.tutorials.picsgram.data

import eu.tutorials.picsgram.model.LoginUserResponse
import eu.tutorials.picsgram.model.RegisterUser
import eu.tutorials.picsgram.model.TokenRequest
import retrofit2.http.*

interface AuthService {

    @POST("Account/Register")
    suspend fun registerUser(@Body registerUser: RegisterUser)

    @POST("https://authteblle20211206115422.azurewebsites.net/token")
    @FormUrlEncoded
    suspend fun loginUser(
        @Field("grant_type") type: String = "password",
        @Field("username") username: String, @Field("password") password: String
    ): LoginUserResponse

    @FormUrlEncoded
    @POST("UserProfile")
    suspend fun addUserImage(
        @Field("UserName") username: String,
        @Field("ProfileImage") imageUrl: String,
        @Header("Authorization") key: String
    )

    @GET("UserProfile")
    suspend fun getUserProfile(
        @Query("UserName") userName: String,
        @Header("Authorization") key: String
    ):String
}