package com.example.booktracker.database

import com.example.booktracker.domain.ReadBook
import com.example.booktracker.domain.ReadingBook
import com.example.booktracker.domain.ToReadBook
import com.example.booktracker.domain.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.getValue
import timber.log.Timber

object DatabaseRepository {
    private const val USERS_TABLE = "users"
    private const val URL =
        "https://book-tracker-da0a1-default-rtdb.europe-west1.firebasedatabase.app/"
    private val database: DatabaseReference = FirebaseDatabase
        .getInstance(URL)
        .getReference(USERS_TABLE)
    private val firebaseUser = FirebaseAuth.getInstance().currentUser

    fun addReadBook(book: ReadBook) {
        if (firebaseUser != null) {
            Timber.d("Adding read book for user ${firebaseUser.uid} in database")
            database.child(firebaseUser.uid).get().addOnSuccessListener { data ->
                val value = data.getValue<User>()
                if (value != null) {
                    Timber.d("value $value")
                    val readBooks = value.readBooks.filter { !it.isDefaultValue() } as MutableList
                    readBooks.add(book)
                    val user = User(
                        readBooks = readBooks,
                        readingBooks = value.readingBooks,
                        toReadBooks = value.toReadBooks
                    )
                    database.child(firebaseUser.uid).setValue(user)
                } else {
                    database.child(firebaseUser.uid).setValue(User(
                        readBooks = listOf(book),
                    ))
                }
            }
        }
    }

    fun addToReadBook(book: ToReadBook) {
        if (firebaseUser != null) {
            Timber.d("Adding to read book for user ${firebaseUser.uid} in database")
            database.child(firebaseUser.uid).get().addOnSuccessListener { data ->
                val value = data.getValue<User>()
                if (value != null) {
                    Timber.d("value $value")
                    val toReadBooks =
                        value.toReadBooks.filter { !it.isDefaultValue() } as MutableList
                    toReadBooks.add(book)
                    val user = User(
                        readBooks = value.readBooks,
                        readingBooks = value.readingBooks,
                        toReadBooks = toReadBooks
                    )
                    database.child(firebaseUser.uid).setValue(user)
                } else {
                    database.child(firebaseUser.uid).setValue(User(
                        toReadBooks = listOf(book),
                    ))
                }
            }
        }
    }

    fun addReadingBook(book: ReadingBook) {
        if (firebaseUser != null) {
            Timber.d("Adding reading book for user ${firebaseUser.uid} in database")
            database.child(firebaseUser.uid).get().addOnSuccessListener { data ->
                val value = data.getValue<User>()
                if (value != null) {
                    Timber.d("value $value")
                    val readingBooks =
                        value.readingBooks.filter { !it.isDefaultValue() } as MutableList
                    readingBooks.add(book)
                    val user = User(
                        readBooks = value.readBooks,
                        readingBooks = readingBooks,
                        toReadBooks = value.toReadBooks
                    )
                    database.child(firebaseUser.uid).setValue(user)
                } else {
                    database.child(firebaseUser.uid).setValue(User(
                        readingBooks = listOf(book),
                    ))
                }
            }
        }
    }

    fun createUser() {
        if (firebaseUser != null) {
            Timber.d("User ${firebaseUser.uid} created in database")
            database.child(firebaseUser.uid).setValue(User())
        }
    }
}