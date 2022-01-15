package com.example.booktracker.domain

data class ReadBook(
    val title: String,
    val author: String,
    val grade: Int,
    val review: String? = null,
    val coverUrl: String? = null
)
