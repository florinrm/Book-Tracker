package com.example.booktracker.domain

data class ToReadBook(
    val title: String,
    val author: String,
    val coverUrl: String? = null
)
