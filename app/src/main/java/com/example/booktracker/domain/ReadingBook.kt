package com.example.booktracker.domain

data class ReadingBook(
    val title: String,
    val author: String,
    val coverUrl: String? = null
)
