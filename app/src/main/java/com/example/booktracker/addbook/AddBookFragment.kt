package com.example.booktracker.addbook

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isGone
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.booktracker.R
import com.example.booktracker.databinding.FragmentAddBookBinding

class AddBookFragment : Fragment() {
    private lateinit var binding: FragmentAddBookBinding
    private lateinit var viewModel: AddBookViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_add_book, container, false)
        viewModel = ViewModelProvider(this).get(AddBookViewModel::class.java)

        addTextToRadioButtons()
        enableFieldForReadBook()

        return binding.root
    }

    private fun addTextToRadioButtons() {
        binding.radioButton.text = READ
        binding.radioButton2.text = READING
        binding.radioButton3.text = TO_READ
    }

    private fun enableFieldForReadBook() {
        binding.radioButton.setOnClickListener {
            binding.addGradeLabel.isGone = false
            binding.addGradeEditview.isGone = false
            binding.addReviewEditview.isGone = false
            binding.addReviewLabel.isGone = false
        }

        binding.radioButton2.setOnClickListener {
            binding.addGradeLabel.isGone = true
            binding.addGradeEditview.isGone = true
            binding.addReviewEditview.isGone = true
            binding.addReviewLabel.isGone = true
        }

        binding.radioButton3.setOnClickListener {
            binding.addGradeLabel.isGone = true
            binding.addGradeEditview.isGone = true
            binding.addReviewEditview.isGone = true
            binding.addReviewLabel.isGone = true
        }
    }
}