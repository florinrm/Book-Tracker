package com.example.booktracker.database

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class DatabaseRepository {
    private val database: DatabaseReference = Firebase.database.reference

}