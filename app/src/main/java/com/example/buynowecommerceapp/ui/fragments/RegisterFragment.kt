package com.example.buynowecommerceapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.example.buynowecommerceapp.R
import com.example.buynowecommerceapp.databinding.FragmentRegisterBinding
import com.example.buynowecommerceapp.models.UserModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase


class RegisterFragment : Fragment() {

    private lateinit var binding: FragmentRegisterBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var database: DatabaseReference
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        //initialization
        binding = FragmentRegisterBinding.inflate(inflater, container, false)
        auth = FirebaseAuth.getInstance()
        //database = FirebaseDatabase.getInstance().reference
        database = Firebase.database.reference

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.btnRegisterRF.setOnClickListener {
            //   binding.progressBarIdRF.visibility=View.VISIBLE
            userRegistration()
        }

    }

    private fun userRegistration() {
        val name: String = binding.etFullNameRF.text.toString().trim()
        val email: String = binding.etEmailRF.text.toString().trim()
        val password: String = binding.etPasswordRF.text.toString().trim()
        val confirmPass: String = binding.etConfirmPasswordRF.text.toString().trim()

        //check name is empty or not
        if (name.isEmpty()) {
            Toast.makeText(requireContext(), "Enter your name pls !", Toast.LENGTH_LONG).show()
            return
        }
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
        //check confirm password  is empty or not
        if (confirmPass.isEmpty()) {
            Toast.makeText(requireContext(), "Re-entered your password", Toast.LENGTH_LONG).show()
            return
        }
        //check password match  or not
        if (password != confirmPass) {
            Toast.makeText(requireContext(), "Password not matched", Toast.LENGTH_LONG).show()
            return
        }


        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
            if (it.isSuccessful) {

                Toast.makeText(requireContext(), "Successfully registered", Toast.LENGTH_LONG)
                    .show()
                val userId = auth.currentUser!!.uid
                val user = UserModel(name, email, password, confirmPass, userId)

                database.child("Users").child(userId).setValue(user).addOnCompleteListener {
                    if (it.isSuccessful) {
                        Navigation.findNavController(requireView()).navigate(R.id.loginFragment)
                        Toast.makeText(
                            requireContext(),
                            "Successfully inserted",
                            Toast.LENGTH_SHORT
                        ).show()

                    } else {
                        Toast.makeText(
                            requireContext(),
                            "Data not saved",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }


            } else {
                Toast.makeText(
                    requireContext(),
                    "Something went wrong,try again",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }


    }
}