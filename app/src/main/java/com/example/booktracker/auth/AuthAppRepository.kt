package com.example.booktracker.auth

import android.app.Application
import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser


class AuthAppRepository(private val application: Application) {
    private val firebaseAuth = FirebaseAuth.getInstance()
    val userLiveData = MutableLiveData<FirebaseUser>()
    val loggedOutLiveData = MutableLiveData<Boolean>()

    init {
        if (firebaseAuth.currentUser != null) {
            userLiveData.postValue(firebaseAuth.currentUser);
            loggedOutLiveData.postValue(false);
        }
    }

    @RequiresApi(Build.VERSION_CODES.P)
    fun signUp(email: String, password: String) {
        firebaseAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(application.mainExecutor, { task ->
                if (task.isSuccessful) {
                    userLiveData.postValue(firebaseAuth.currentUser);
                } else {
                    Toast.makeText(
                        application.applicationContext,
                        "Registration failure: " + task.exception?.message,
                        Toast.LENGTH_SHORT
                    )
                        .show();
                }
            })
    }

    @RequiresApi(Build.VERSION_CODES.P)
    fun login(email: String, password: String) {
        firebaseAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(application.mainExecutor, { task ->
                if (task.isSuccessful) {
                    userLiveData.postValue(firebaseAuth.currentUser);
                } else {
                    Toast.makeText(
                        application.applicationContext,
                        "Login failure: " + task.exception?.message,
                        Toast.LENGTH_SHORT
                    )
                        .show();
                }
            })
    }

    fun logOut() {
        firebaseAuth.signOut()
        loggedOutLiveData.postValue(true)
    }
}