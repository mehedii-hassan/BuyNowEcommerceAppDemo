package com.example.buynowecommerceapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.buynowecommerceapp.R
import com.example.buynowecommerceapp.adapters.CategoryAdapter
import com.example.buynowecommerceapp.adapters.ProductAdapter
import com.example.buynowecommerceapp.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {


    private lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        // val categoryImageList = resources.getIntArray(R.array.CategoryImageList)
        val categoryNameList = resources.getStringArray(R.array.CategoryNameList)

        val productList = ArrayList<Int>()
        productList.add(R.drawable.bn)
        productList.add(R.drawable.bn)
        productList.add(R.drawable.bn)
        productList.add(R.drawable.bn)
        productList.add(R.drawable.bn)
        productList.add(R.drawable.bn)
        productList.add(R.drawable.bn)
        productList.add(R.drawable.bn)
        productList.add(R.drawable.bn)
        productList.add(R.drawable.bn)

        val list = ArrayList<Int>()
        list.add(R.drawable.bird3)
        list.add(R.drawable.bird4)
        list.add(R.drawable.bird3)
        list.add(R.drawable.bird4)
        list.add(R.drawable.bird3)
        list.add(R.drawable.bird4)
        list.add(R.drawable.bird3)

        val adapter = CategoryAdapter(list, categoryNameList)
        binding.rvCategory.layoutManager =
            LinearLayoutManager(view.context, LinearLayoutManager.HORIZONTAL, false)
        binding.rvCategory.adapter = adapter

        val productAdapter = ProductAdapter(productList)
        binding.rvProduct.layoutManager =
            LinearLayoutManager(view.context, LinearLayoutManager.HORIZONTAL, false)
        binding.rvProduct.adapter = productAdapter


    }

}