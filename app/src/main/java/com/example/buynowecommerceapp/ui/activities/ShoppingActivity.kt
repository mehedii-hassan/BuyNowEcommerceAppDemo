package com.example.buynowecommerceapp.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.example.buynowecommerceapp.R
import com.example.buynowecommerceapp.databinding.ActivityShoppingBinding

class ShoppingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityShoppingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShoppingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //val navController = findNavController(R.id.fragmentContainerView2)
       // NavigationUI.setupWithNavController(binding.bottomNavigationId,navController)
        //binding.bottomNavigationId.setupWithNavController(navController)
    }
}