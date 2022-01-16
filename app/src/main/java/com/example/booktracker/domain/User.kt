package com.example.booktracker.domain

data class User(
    val readBooks: List<ReadBook> = listOf(ReadBook()),
    val toReadBooks: List<ToReadBook> = listOf(ToReadBook()),
    val readingBooks: List<ReadingBook> = listOf(ReadingBook())
) {
    override fun toString(): String {
        return "User(readBooks=$readBooks, toReadBooks=$toReadBooks, readingBooks=$readingBooks)"
    }
}