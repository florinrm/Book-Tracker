package com.example.booktracker.signup

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.booktracker.MenuActivity
import com.example.booktracker.R
import com.example.booktracker.database.DatabaseRepository
import com.example.booktracker.databinding.FragmentSignUpBinding

class SignUpFragment : Fragment() {
    private lateinit var binding: FragmentSignUpBinding
    private lateinit var viewModel: SignUpViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_sign_up, container, false
        )
        viewModel = ViewModelProvider(this).get(SignUpViewModel::class.java)

        binding.signModelView = viewModel

        viewModel.user.observe(viewLifecycleOwner, { user ->
            if (user != null) {
                DatabaseRepository.createUser()
                Toast.makeText(activity, "User created!", Toast.LENGTH_SHORT).show()
                val intent = Intent(activity, MenuActivity::class.java)
                startActivity(intent)
            }
        })
        binding.signupButton.setOnClickListener {
            createNewAccount()
        }

        return binding.root
    }

    private fun createNewAccount() {
        val email = binding.signupEmail.text.toString()
        val password = binding.signupPassword.text.toString()

        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(
                activity,
                "Email and password cannot be empty!",
                Toast.LENGTH_SHORT
            ).show()
            return
        }

        viewModel.createNewAccount(email, password)
    }
}