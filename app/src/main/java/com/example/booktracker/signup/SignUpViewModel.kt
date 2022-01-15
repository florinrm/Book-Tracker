package com.example.booktracker.signup

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.booktracker.auth.AuthAppRepository
import com.google.firebase.auth.FirebaseUser

class SignUpViewModel(application: Application) : AndroidViewModel(application) {
    val user: MutableLiveData<FirebaseUser>
    private val authAppRepository: AuthAppRepository = AuthAppRepository(application)

    init {
        user = authAppRepository.userLiveData
    }

    fun createNewAccount(email: String, password: String) {
        authAppRepository.signUp(email, password)
    }
}