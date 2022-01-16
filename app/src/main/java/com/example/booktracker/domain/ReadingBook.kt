package com.example.booktracker.domain

data class ReadingBook(
    val title: String = "",
    val author: String = "",
    val coverUrl: String = ""
) : Book {
    override fun isDefaultValue(): Boolean {
        return title == ""
                && author == ""
                && coverUrl == ""
    }

    override fun toString(): String {
        return "ReadingBook(title='$title', author='$author', coverUrl='$coverUrl')"
    }


}
