package com.example.booktracker.done

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.example.booktracker.databinding.BookItemBinding
import com.example.booktracker.domain.ReadBook

class DoneListRecycleViewAdapter(
    private val books: List<ReadBook>
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = BookItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AllReadBooksViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as AllReadBooksViewHolder).bind(position)
    }

    override fun getItemCount() = books.size

    internal inner class AllReadBooksViewHolder(private val viewBinding: BookItemBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {

        fun bind(position: Int) {
            val book = books[position]
            viewBinding.bookAuthorItem.text = book.author
            viewBinding.bookTitleItem.text = book.title
            viewBinding.bookRatingItem.rating = book.grade.toFloat()
        }
    }
}
