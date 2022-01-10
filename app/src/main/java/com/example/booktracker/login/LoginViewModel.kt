package com.example.booktracker.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {
    private var _password = MutableLiveData<String>()
    private val password: LiveData<String>
        get() = _password

    private var _username = MutableLiveData<String>()
    private val username: LiveData<String>
        get() = _username


    fun login() {

    }

}