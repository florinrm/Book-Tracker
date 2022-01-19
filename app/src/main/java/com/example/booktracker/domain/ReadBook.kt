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

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ReadBook

        if (title != other.title) return false
        if (author != other.author) return false
        if (grade != other.grade) return false
        if (review != other.review) return false
        if (coverUrl != other.coverUrl) return false

        return true
    }

    override fun hashCode(): Int {
        var result = title.hashCode()
        result = 31 * result + author.hashCode()
        result = 31 * result + grade
        result = 31 * result + review.hashCode()
        result = 31 * result + coverUrl.hashCode()
        return result
    }


}
