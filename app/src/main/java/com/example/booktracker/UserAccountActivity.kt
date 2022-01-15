package com.example.booktracker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import timber.log.Timber

class UserAccountActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.plant(Timber.DebugTree())
        setContentView(R.layout.activity_user_account)
    }
}