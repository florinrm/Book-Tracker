package com.example.booktracker.addbook

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.example.booktracker.database.DatabaseRepository
import com.example.booktracker.domain.ReadBook
import com.example.booktracker.domain.ReadingBook
import com.example.booktracker.domain.ToReadBook

class AddBookViewModel(application: Application) : AndroidViewModel(application) {
    fun addReadBook(book: ReadBook) {
        DatabaseRepository.addReadBook(book)
    }
    fun addReadingBook(book: ReadingBook) {
        DatabaseRepository.addReadingBook(book)
    }

    fun addToReadBook(book: ToReadBook) {
        DatabaseRepository.addToReadBook(book)
    }
}