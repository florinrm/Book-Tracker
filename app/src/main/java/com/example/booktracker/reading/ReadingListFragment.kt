package com.example.booktracker.reading

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.booktracker.R

class ReadingListFragment : Fragment() {
    private lateinit var viewModel: ReadingViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(ReadingViewModel::class.java)
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_reading_list, container, false)
    }
}