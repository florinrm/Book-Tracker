package com.example.booktracker.domain

data class User(
    val userId: String,
    val readBooks: List<ReadBook>,
    val toReadBooks: List<ToReadBook>,
    val readingBooks: List<ReadingBook>
)