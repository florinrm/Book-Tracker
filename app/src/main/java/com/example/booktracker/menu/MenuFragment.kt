package com.example.booktracker.menu

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
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

        binding.root.isFocusableInTouchMode = true
        binding.root.requestFocus()
        binding.root.setOnKeyListener(object : View.OnKeyListener {
            override fun onKey(v: View?, keyCode: Int, event: KeyEvent?): Boolean {
                if (event != null && event.action == KeyEvent.ACTION_DOWN) {
                    if (keyCode == KeyEvent.KEYCODE_BACK) {
                        return true
                    }
                }
                return false
            }
        })

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
            val gmmIntentUri = Uri.parse("geo:0,0?q=book+shops")
            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
            mapIntent.setPackage("com.google.android.apps.maps")
            startActivity(mapIntent)
        }
    }
}