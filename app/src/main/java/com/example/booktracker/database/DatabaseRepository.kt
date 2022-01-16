package com.example.booktracker.database

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
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
                    database.child(firebaseUser.uid).setValue(
                        User(
                            readBooks = listOf(book),
                        )
                    )
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
                    database.child(firebaseUser.uid).setValue(
                        User(
                            toReadBooks = listOf(book),
                        )
                    )
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
                    database.child(firebaseUser.uid).setValue(
                        User(
                            readingBooks = listOf(book),
                        )
                    )
                }
            }
        }
    }

    fun getReadBooks(): LiveData<List<ReadBook>> {
        val readBooks = MutableLiveData<List<ReadBook>>()
        if (firebaseUser != null) {
            Timber.d("Fetching read books for user ${firebaseUser.uid} in database")
            database.child(firebaseUser.uid).get().addOnSuccessListener { data ->
                val value = data.getValue<User>()
                if (value != null) {
                    Timber.d("value $value")
                    val books = value.readBooks.filter { !it.isDefaultValue() }
                    Timber.d("books $books")
                    readBooks.postValue(books)
                }
            }
        }
        return readBooks
    }

    fun getToReadBooks(): LiveData<List<ToReadBook>> {
        val toReadBooks = MutableLiveData<List<ToReadBook>>()
        if (firebaseUser != null) {
            Timber.d("Fetching to read books for user ${firebaseUser.uid} in database")
            database.child(firebaseUser.uid).get().addOnSuccessListener { data ->
                val value = data.getValue<User>()
                if (value != null) {
                    Timber.d("value $value")
                    val books = value.toReadBooks.filter { !it.isDefaultValue() }
                    Timber.d("books $books")
                    toReadBooks.postValue(books)
                }
            }
        }
        return toReadBooks
    }

    fun getReadingBooks(): LiveData<List<ReadingBook>> {
        val readingBooks = MutableLiveData<List<ReadingBook>>()
        if (firebaseUser != null) {
            Timber.d("Fetching reading books for user ${firebaseUser.uid} in database")
            database.child(firebaseUser.uid).get().addOnSuccessListener { data ->
                val value = data.getValue<User>()
                if (value != null) {
                    Timber.d("value $value")
                    val books = value.readingBooks.filter { !it.isDefaultValue() }
                    Timber.d("books $books")
                    readingBooks.postValue(books)
                }
            }
        }
        return readingBooks
    }

    fun createUser() {
        if (firebaseUser != null) {
            Timber.d("User ${firebaseUser.uid} created in database")
            database.child(firebaseUser.uid).setValue(User())
        }
    }
}