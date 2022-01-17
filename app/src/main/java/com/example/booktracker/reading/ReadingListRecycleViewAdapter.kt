package com.example.booktracker.reading

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.example.booktracker.databinding.BookItemBinding
import com.example.booktracker.domain.ReadingBook

class ReadingListRecycleViewAdapter(
    private val books: List<ReadingBook>,
    private val navController: NavController
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = BookItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AllReadingBooksViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ReadingListRecycleViewAdapter.AllReadingBooksViewHolder).bind(position)
    }

    override fun getItemCount() = books.size

    internal inner class AllReadingBooksViewHolder(private val viewBinding: BookItemBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {

        init {
            viewBinding.root.setOnClickListener {
                navController.navigate(
                    ReadingListFragmentDirections
                        .actionReadingListFragmentToReadingBookFragment()
                )
            }
        }

        fun bind(position: Int) {
            val book = books[position]
            viewBinding.bookAuthorItem.text = book.author
            viewBinding.bookTitleItem.text = book.title
        }
    }
}