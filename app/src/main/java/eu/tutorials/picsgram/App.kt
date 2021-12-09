package eu.tutorials.picsgram

import android.app.Application
import eu.tutorials.picsgram.data.PreferenceStore
import eu.tutorials.picsgram.data.Repository
import eu.tutorials.picsgram.data.RetrofitApi

class App:Application() {

    val preferenceStore by lazy {
        PreferenceStore(this)
    }
     val repository by lazy {
        Repository(RetrofitApi.authService,preferenceStore = preferenceStore)
    }

}