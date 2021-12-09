package eu.tutorials.picsgram.data

import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import eu.tutorials.picsgram.model.LoginUserResponse
import eu.tutorials.picsgram.model.RegisterUser
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException

class Repository(private val authService: AuthService,private val preferenceStore: PreferenceStore) {

    suspend fun registerUser(registerUser: RegisterUser){
        authService.registerUser(registerUser = registerUser)
    }

    suspend fun loginUser(username:String,password:String):LoginUserResponse =
        authService.loginUser(username = username, password = password)

    suspend fun addUserImage(username: String,imageUrl:String,key:String){
        authService.addUserImage(username = username,imageUrl = imageUrl,key = key)
    }

    suspend fun getUserProfile(username:String,key:String):String =
        authService.getUserProfile(userName = username, key = key)


    val tokenFlow: Flow<String> = preferenceStore.tokenFlow

    suspend fun saveToken(token : String) {
        preferenceStore.saveToken(token = token)
    }

    val emailFlow: Flow<String> = preferenceStore.emailFlow

    suspend fun saveEmail(email : String) {
        preferenceStore.saveEmail(email = email)
    }
    suspend fun clearUserToken(){
        preferenceStore.clearUserToken()
    }

}