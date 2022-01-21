package com.example.booktracker.menu

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.booktracker.R
import com.example.booktracker.databinding.FragmentMenuBinding
import com.google.android.material.tabs.TabLayoutMediator

class MenuFragment : Fragment() {
    private lateinit var binding: FragmentMenuBinding
    lateinit var viewModel: MenuViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_menu, container, false)
        viewModel = ViewModelProvider(this).get(MenuViewModel::class.java)

        setHasOptionsMenu(true)

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

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.sign_out_button) {
            viewModel.logout()
            findNavController().navigate(MenuFragmentDirections.actionMenuFragmentToLoginFragment3())
            return true
        }

        return false
    }

    private fun setOnClickListeners() {
        binding.addBookButton.setOnClickListener {
            findNavController().navigate(MenuFragmentDirections.actionMenuFragmentToAddBookFragment())
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
    }
}