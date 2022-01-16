package com.example.booktracker.reading

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.booktracker.database.DatabaseRepository

class ReadingListViewModel(application: Application): AndroidViewModel(application) {
    fun loadBooks() = DatabaseRepository.getReadingBooks()
}