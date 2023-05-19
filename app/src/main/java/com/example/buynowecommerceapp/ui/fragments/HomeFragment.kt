package com.example.buynowecommerceapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.buynowecommerceapp.R
import com.example.buynowecommerceapp.adapters.CategoryAdapter
import com.example.buynowecommerceapp.adapters.FeatureProductAdapter
import com.example.buynowecommerceapp.adapters.PopularProductAdapter
import com.example.buynowecommerceapp.adapters.ProductAdapter
import com.example.buynowecommerceapp.adapters.ShopNowAdapter
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


        val list = ArrayList<Int>()
        list.add(R.drawable.img1)
        list.add(R.drawable.img2)
        list.add(R.drawable.img1)
        list.add(R.drawable.img2)
        list.add(R.drawable.img1)
        list.add(R.drawable.img2)
        list.add(R.drawable.img1)
        list.add(R.drawable.img2)
        list.add(R.drawable.img1)
        list.add(R.drawable.img2)

        val listOne = ArrayList<Int>()
        listOne.add(R.drawable.img1)
        listOne.add(R.drawable.img2)
        listOne.add(R.drawable.img1)
        listOne.add(R.drawable.img2)


        val adapter = CategoryAdapter(list, categoryNameList)
        binding.rvCategory.layoutManager =
            LinearLayoutManager(view.context, LinearLayoutManager.HORIZONTAL, false)
        binding.rvCategory.adapter = adapter

        val productAdapter = ProductAdapter(list)
        binding.rvProduct.layoutManager =
            LinearLayoutManager(view.context, LinearLayoutManager.HORIZONTAL, false)
        binding.rvProduct.adapter = productAdapter

        val shopNowAdapter = ShopNowAdapter(list)
        binding.rvShopNow.layoutManager =
            LinearLayoutManager(view.context, LinearLayoutManager.HORIZONTAL, false)
        binding.rvShopNow.adapter = shopNowAdapter

        val featureProductAdapter = FeatureProductAdapter(listOne)
        binding.rvFeatureProducts.layoutManager =
            GridLayoutManager(view.context, 2)
        binding.rvFeatureProducts.adapter = featureProductAdapter

        val popularProductAdapter = PopularProductAdapter(listOne)
        binding.rvPopularProducts.layoutManager = GridLayoutManager(view.context, 2)
        binding.rvPopularProducts.adapter = popularProductAdapter


    }

}