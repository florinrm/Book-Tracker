package com.example.booktracker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.booktracker.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth
import timber.log.Timber

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)

        setContentView(binding.root)
        Timber.plant(Timber.DebugTree())

        auth = FirebaseAuth.getInstance()
    }

    override fun onStart() {
        super.onStart()
        if (auth.currentUser == null) {
            login()
        }
    }

    private fun login() {
    }
}