package com.example.booktracker.menu

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.booktracker.auth.AuthAppRepository
import com.google.firebase.auth.FirebaseUser

class MenuViewModel(application: Application) : AndroidViewModel(application) {
    private val user: MutableLiveData<FirebaseUser>
    private val authAppRepository: AuthAppRepository = AuthAppRepository(application)

    init {
        user = authAppRepository.userLiveData
    }

    fun logout() {
        authAppRepository.logOut()
    }
}