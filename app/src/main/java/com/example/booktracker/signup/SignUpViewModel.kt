package com.example.booktracker.signup

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth

class SignUpViewModel : ViewModel() {
    private var _password = MutableLiveData<String>()
    private val password: LiveData<String>
        get() = _password

    private var _email = MutableLiveData<String>()
    private val email: LiveData<String>
        get() = _email

    private val auth: FirebaseAuth = FirebaseAuth.getInstance()

    fun createNewAccount() {
        val emailValue = email.value
        val passwordValue = password.value
    }
}