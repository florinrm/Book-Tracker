package com.example.booktracker.menu

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
import com.example.booktracker.login.LoginViewModel

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

        binding.addBookButton.setOnClickListener {
            findNavController().navigate(MenuFragmentDirections.actionMenuFragmentToAddBookFragment())
        }

        binding.signOutButton.setOnClickListener {
            viewModel.logout()
            findNavController().navigate(MenuFragmentDirections.actionMenuFragmentToLoginFragment3())
        }

        return binding.root
    }
}