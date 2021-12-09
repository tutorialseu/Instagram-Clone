package eu.tutorials.picsgram.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import eu.tutorials.picsgram.Resource
import eu.tutorials.picsgram.data.Repository
import eu.tutorials.picsgram.model.LoginUserResponse
import eu.tutorials.picsgram.model.RegisterUser
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import java.lang.Exception

class MainViewModel(private val repository: Repository) : ViewModel() {

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _isError = MutableStateFlow(false)
    val isError: StateFlow<Boolean>
        get() = _isError

    private val _userToken = MutableStateFlow<Resource<LoginUserResponse>?>(null)
    val userToken:StateFlow<Resource<LoginUserResponse>?>
    get() = _userToken

    private val _userImage = MutableStateFlow<Resource<String>?>(null)
    val userImage:StateFlow<Resource<String>?>
        get() = _userImage


    val errorHandler = CoroutineExceptionHandler { _, error ->
        if (error is Exception) {
           _isError.value = true
        }
    }

    fun registerUser(registerUser: RegisterUser) {
        _isLoading.value = true
            viewModelScope.launch(Dispatchers.IO + errorHandler) {
                repository.registerUser(registerUser = registerUser)
                _isLoading.value = false
            }
    }

    fun loginUser(username:String,password:String){
        viewModelScope.launch(Dispatchers.IO + errorHandler) {
            delay(500L)
            val result = repository.loginUser(username = username, password = password)
            _userToken.value = Resource.Success(result)
        }

    }


    fun addUserImage(username: String,imageUrl:String,key:String) {
        _isLoading.value = true
        viewModelScope.launch(Dispatchers.IO + errorHandler) {
            delay(500L)
            repository.addUserImage(username = username,imageUrl = imageUrl,key = key)
            _isLoading.value = false
        }
    }

    fun getUserProfile(username:String,key:String){
        viewModelScope.launch(Dispatchers.IO+errorHandler) {
            delay(500L)
            val result  = repository.getUserProfile(username = username,key = key)
            _userImage.value =  Resource.Success(result)
        }
    }

    fun saveToken(token:String){
        viewModelScope.launch {
            delay(500L)
            repository.saveToken(token = token)
        }
    }

    fun saveEmail(email:String){
        viewModelScope.launch {
            delay(500L)
            repository.saveEmail(email = email)
        }
    }

    private val _prefToken = MutableStateFlow("")
     fun prefToken():StateFlow<String>{
         viewModelScope.launch {
             repository.tokenFlow.collect {
                 _prefToken.value = it
             }
         }
         return _prefToken
     }

    private val _prefEmail = MutableStateFlow<String>("")
   fun prefEmail():StateFlow<String>{
       viewModelScope.launch {
           repository.emailFlow.collect {
               _prefEmail.value = it
           }
       }
       return _prefEmail
   }

     fun clearUserToken(){
         viewModelScope.launch {
             repository.clearUserToken()
         }
    }

}