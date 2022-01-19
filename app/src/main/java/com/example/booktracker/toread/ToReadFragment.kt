package com.example.booktracker.toread

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.booktracker.R
import com.example.booktracker.databinding.FragmentToReadBinding

class ToReadFragment : Fragment() {
    private lateinit var binding: FragmentToReadBinding
    private lateinit var viewModel: ToReadViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_to_read, container, false)
        viewModel = ViewModelProvider(this).get(ToReadViewModel::class.java)

        initUi()

        return binding.root
    }

    private fun initUi() {
        viewModel.loadBooks().observe(viewLifecycleOwner, { books ->
            binding.toReadBooksList.adapter = ToReadRecycleViewAdapter(books)
        })
    }
}
