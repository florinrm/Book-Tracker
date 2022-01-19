package com.example.booktracker.domain

data class User(
    val readBooks: List<ReadBook> = listOf(ReadBook()),
    val toReadBooks: List<ToReadBook> = listOf(ToReadBook()),
    val readingBooks: List<ReadingBook> = listOf(ReadingBook())
) {
    override fun toString(): String {
        return "User(readBooks=$readBooks, toReadBooks=$toReadBooks, readingBooks=$readingBooks)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as User

        if (readBooks != other.readBooks) return false
        if (toReadBooks != other.toReadBooks) return false
        if (readingBooks != other.readingBooks) return false

        return true
    }

    override fun hashCode(): Int {
        var result = readBooks.hashCode()
        result = 31 * result + toReadBooks.hashCode()
        result = 31 * result + readingBooks.hashCode()
        return result
    }
}