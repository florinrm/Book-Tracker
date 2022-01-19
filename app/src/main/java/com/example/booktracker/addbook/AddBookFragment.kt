package com.example.booktracker.addbook

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isGone
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.booktracker.R
import com.example.booktracker.databinding.FragmentAddBookBinding
import com.example.booktracker.domain.ReadBook
import com.example.booktracker.domain.ReadingBook
import com.example.booktracker.domain.ToReadBook

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
        addOnClickListeners()

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

    private fun addOnClickListeners() {
        binding.addBookButton.setOnClickListener {
            addBook()
        }

        binding.cancelAddBookButton.setOnClickListener {
            findNavController().navigate(AddBookFragmentDirections.actionAddBookFragmentToMenuFragment())
        }
    }

    private fun addBook() {
        when {
            binding.radioButton.isChecked -> {
                addReadBook()
            }
            binding.radioButton2.isChecked -> {
                addReadingBook()
            }
            binding.radioButton3.isChecked -> {
                addToReadBook()
            }
        }
    }

    private fun checkFieldsValidity(): Boolean {
        val title = binding.addTitleEditview.text.toString()
        val author = binding.addAuthorEditview.text.toString()

        if (title.isEmpty() || author.isEmpty()) {
            Toast.makeText(
                activity,
                "Title and/or author cannot be empty!",
                Toast.LENGTH_SHORT
            ).show()
            return false
        }

        if (binding.radioButton.isChecked) {
            val grade = binding.addGradeEditview.text.toString().toIntOrNull()
            val review = binding.addReviewEditview.text.toString()

            if (review.isEmpty()) {
                Toast.makeText(
                    activity,
                    "Review cannot be empty!",
                    Toast.LENGTH_SHORT
                ).show()
                return false
            }

            if (grade == null || grade < 0 || grade > 10) {
                Toast.makeText(
                    activity,
                    "Invalid grade value!",
                    Toast.LENGTH_SHORT
                ).show()
                return false
            }
        }

        return true
    }

    private fun addBookSuccesfully() {
        Toast.makeText(activity, "Book added!", Toast.LENGTH_SHORT).show()
        findNavController().navigate(AddBookFragmentDirections.actionAddBookFragmentToMenuFragment())
    }

    private fun addReadBook() {
        if (checkFieldsValidity()) {
            viewModel.addReadBook(
                ReadBook(
                    title = binding.addTitleEditview.text.toString(),
                    author = binding.addAuthorEditview.text.toString(),
                    grade = binding.addGradeEditview.text.toString().toInt(),
                    review = binding.addReviewEditview.text.toString()
                )
            )

            addBookSuccesfully()
        }
    }

    private fun addReadingBook() {
        if (checkFieldsValidity()) {
            viewModel.addReadingBook(ReadingBook(
                title = binding.addTitleEditview.text.toString(),
                author = binding.addAuthorEditview.text.toString(),
            ))

            addBookSuccesfully()
        }
    }

    private fun addToReadBook() {
        if (checkFieldsValidity()) {
            viewModel.addReadingBook(ReadingBook(
                title = binding.addTitleEditview.text.toString(),
                author = binding.addAuthorEditview.text.toString(),
            ))

            addBookSuccesfully()
        }
    }
}