package com.example.booktracker.toread

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.booktracker.R

class ToReadBookFragment : Fragment() {
    private lateinit var viewModel: ToReadBookViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(ToReadBookViewModel::class.java)
        return inflater.inflate(R.layout.to_read_book_fragment, container, false)
    }
}