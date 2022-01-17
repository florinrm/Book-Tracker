package com.example.booktracker.reading

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.booktracker.R
import com.example.booktracker.databinding.FragmentReadingListBinding

class ReadingListFragment : Fragment() {
    private lateinit var binding: FragmentReadingListBinding
    private lateinit var viewModel: ReadingListViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_reading_list, container, false)
        viewModel = ViewModelProvider(this).get(ReadingListViewModel::class.java)

        initUi()

        return binding.root
    }

    private fun initUi() {
        viewModel.loadBooks().observe(viewLifecycleOwner, { books ->
            binding.readingBooksList.adapter = ReadingListRecycleViewAdapter(books, findNavController())
        })
    }
}