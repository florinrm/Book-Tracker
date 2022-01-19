package com.example.booktracker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import timber.log.Timber

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.plant(Timber.DebugTree())
        setContentView(R.layout.activity_menu)
    }
}