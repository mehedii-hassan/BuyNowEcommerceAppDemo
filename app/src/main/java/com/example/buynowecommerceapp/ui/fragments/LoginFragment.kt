package com.example.buynowecommerceapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.buynowecommerceapp.R
import com.example.buynowecommerceapp.databinding.FragmentLoginBinding
import com.google.firebase.auth.FirebaseAuth


class LoginFragment : Fragment() {


    private lateinit var auth: FirebaseAuth
    private lateinit var binding: FragmentLoginBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // initialization
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        auth = FirebaseAuth.getInstance()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.btnLogin.setOnClickListener {
            userLogin()

        }
    }

    private fun userLogin() {
        val email: String = binding.etEmail.text.toString().trim()
        val password: String = binding.etPassword.text.toString().trim()

        //check email is empty or not
        if (email.isEmpty()) {
            Toast.makeText(requireContext(), "Enter your email pls !", Toast.LENGTH_LONG).show()
            return
        }
        //check valid email  or not
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Toast.makeText(requireContext(), "Please enter a valid  Email", Toast.LENGTH_LONG)
                .show();
            return
        }
        //check password is empty or not
        if (password.isEmpty()) {
            Toast.makeText(requireContext(), "Enter your password pls !", Toast.LENGTH_LONG).show()
            return
        }
        //check password length less then 6  or not
        if (password.length < 6) {
            Toast.makeText(
                requireContext(),
                "Password length should be at least 6",
                Toast.LENGTH_LONG
            ).show()
            return
        }

        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener {

            if (it.isSuccessful) {
                Toast.makeText(requireContext(), "Successfully Login", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(requireContext(), "Login failed", Toast.LENGTH_SHORT).show()

            }
        }

    }

}