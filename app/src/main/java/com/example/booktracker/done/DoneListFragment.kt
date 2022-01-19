package com.example.booktracker.done

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.booktracker.R
import com.example.booktracker.databinding.FragmentDoneListBinding
import timber.log.Timber

class DoneListFragment : Fragment() {
    private lateinit var binding: FragmentDoneListBinding
    private lateinit var viewModel: DoneListViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_done_list, container, false)
        viewModel = ViewModelProvider(this).get(DoneListViewModel::class.java)

        initUi()

        return binding.root
    }

    private fun initUi() {
        viewModel.loadBooks().observe(viewLifecycleOwner, { books ->
            binding.readBooksList.adapter = DoneListRecycleViewAdapter(books)
        })
    }
}
