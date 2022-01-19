package com.example.booktracker.done

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.booktracker.database.DatabaseRepository

class DoneListViewModel(application: Application): AndroidViewModel(application) {
    fun loadBooks() = DatabaseRepository.getReadBooks()
}