package com.example.booktracker.menu

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.booktracker.R
import com.example.booktracker.databinding.FragmentMenuBinding

class MenuFragment : Fragment() {
    private lateinit var binding: FragmentMenuBinding
    private lateinit var viewModel: MenuViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_menu, container, false)
        viewModel = ViewModelProvider(this).get(MenuViewModel::class.java)

        binding.menuModelView = viewModel
        setOnClickListeners()

        return binding.root
    }

    private fun setOnClickListeners() {
        binding.addBookButton.setOnClickListener {
            findNavController().navigate(MenuFragmentDirections.actionMenuFragmentToAddBookFragment())
        }

        binding.signOutButton.setOnClickListener {
            viewModel.logout()
            findNavController().navigate(MenuFragmentDirections.actionMenuFragmentToLoginFragment3())
        }

        binding.seeReadBooksButton.setOnClickListener {
            findNavController().navigate(MenuFragmentDirections.actionMenuFragmentToDoneListFragment())
        }

        binding.seeReadingBooksButton.setOnClickListener {
            findNavController().navigate(MenuFragmentDirections.actionMenuFragmentToReadingListFragment())
        }

        binding.seeToReadBooksButton.setOnClickListener {
            findNavController().navigate(MenuFragmentDirections.actionMenuFragmentToToReadFragment())
        }

        binding.checkBookShopsButton.setOnClickListener {
            // TODO: launch Google Maps for nearby book shops
            val gmmIntentUri = Uri.parse("geo:0,0?q=book+shops")
            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
            mapIntent.setPackage("com.google.android.apps.maps")
            startActivity(mapIntent)
        }
    }
}