package com.example.booktracker.login

import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
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
                findNavController().navigate(LoginFragmentDirections.actionLoginFragment3ToMenuFragment())
            } else {
                Toast.makeText(activity, "Cannot login!", Toast.LENGTH_SHORT).show()
            }
        })

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

        binding.createAccountButton.setOnClickListener {
            findNavController().navigate(LoginFragmentDirections.actionLoginFragment3ToSignUpFragment2())
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