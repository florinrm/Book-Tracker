package com.example.booktracker.reading

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.booktracker.R

class ReadingBookFragment : Fragment() {
    private lateinit var viewModel: ReadingBookViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(ReadingBookViewModel::class.java)
        return inflater.inflate(R.layout.reading_book_fragment, container, false)
    }
}