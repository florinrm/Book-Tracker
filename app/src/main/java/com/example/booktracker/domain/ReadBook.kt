package com.example.booktracker.domain

data class ReadBook(
    val title: String = "",
    val author: String = "",
    val grade: Int = 0,
    val review: String = "",
    val coverUrl: String = ""
): Book {
    override fun isDefaultValue(): Boolean {
        return title == ""
                && author == ""
                && grade == 0
                && review == ""
                && coverUrl == ""
    }

    override fun toString(): String {
        return "ReadBook(title='$title', author='$author', grade=$grade, review='$review', coverUrl='$coverUrl')"
    }


}
