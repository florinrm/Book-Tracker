package com.example.booktracker.domain

data class ToReadBook(
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
        return "ToReadBook(title='$title', author='$author', coverUrl='$coverUrl')"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ToReadBook

        if (title != other.title) return false
        if (author != other.author) return false
        if (coverUrl != other.coverUrl) return false

        return true
    }

    override fun hashCode(): Int {
        var result = title.hashCode()
        result = 31 * result + author.hashCode()
        result = 31 * result + coverUrl.hashCode()
        return result
    }
}

