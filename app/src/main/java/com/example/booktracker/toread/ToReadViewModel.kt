package com.example.booktracker.toread

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.booktracker.database.DatabaseRepository

class ToReadViewModel(application: Application): AndroidViewModel(application) {
    fun loadBooks() = DatabaseRepository.getToReadBooks()
}