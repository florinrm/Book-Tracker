package com.example.booktracker.toread

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.example.booktracker.databinding.BookItemBinding
import com.example.booktracker.domain.ToReadBook
import timber.log.Timber

class ToReadRecycleViewAdapter(
    private val books: List<ToReadBook>
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = BookItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AllToReadBooksViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ToReadRecycleViewAdapter.AllToReadBooksViewHolder).bind(position)
    }

    override fun getItemCount() = books.size

    internal inner class AllToReadBooksViewHolder(private val viewBinding: BookItemBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {

        fun bind(position: Int) {
            val book = books[position]
            viewBinding.bookAuthorItem.text = book.author
            viewBinding.bookTitleItem.text = book.title
            viewBinding.bookRatingItem.isVisible = false
        }
    }
}
