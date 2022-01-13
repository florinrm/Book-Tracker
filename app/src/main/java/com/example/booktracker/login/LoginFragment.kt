package com.example.booktracker.login

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.booktracker.MainActivity
import com.example.booktracker.R
import com.example.booktracker.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    private lateinit var viewModel: LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_login, container, false
        )
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        viewModel.user.observe(viewLifecycleOwner, { user ->
            if (user != null) {
                Toast.makeText(activity, "User logged in!", Toast.LENGTH_SHORT).show()
                val intent = Intent(activity, MainActivity::class.java)
                startActivity(intent)
            }
        })

        binding.createAccountButton.setOnClickListener {
            findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToSignUpFragment())
        }

        binding.loginButton.setOnClickListener {
            login()
        }

        return binding.root
    }

    private fun login() {
        val email = binding.loginEmail.text.toString()
        val password = binding.loginPassword.text.toString()

        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(
                activity,
                "Email and password cannot be empty!",
                Toast.LENGTH_SHORT
            ).show()
            return
        }

        viewModel.login(email, password)
    }
}