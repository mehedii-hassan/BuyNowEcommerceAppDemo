package com.example.buynowecommerceapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
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


        //val imageSlider = findViewById<ImageSlider>(R.id.image_slider)


        val recentProductList = ArrayList<Int>()
        recentProductList.add(R.drawable.chair_one)
        recentProductList.add(R.drawable.chair_one)
        recentProductList.add(R.drawable.chair_one)
        recentProductList.add(R.drawable.chair_one)
        recentProductList.add(R.drawable.chair_one)
        recentProductList.add(R.drawable.chair_one)
        recentProductList.add(R.drawable.chair_one)
        recentProductList.add(R.drawable.chair_one)

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


        val categoryList = ArrayList<Int>()
        categoryList.add(R.drawable.sofa)
        categoryList.add(R.drawable.sofa)
        categoryList.add(R.drawable.sofa)
        categoryList.add(R.drawable.sofa)
        categoryList.add(R.drawable.sofa)
        categoryList.add(R.drawable.sofa)
        categoryList.add(R.drawable.sofa)
        categoryList.add(R.drawable.baseline_more_horiz_24)


        val listOne = ArrayList<Int>()
        listOne.add(R.drawable.img1)
        listOne.add(R.drawable.img2)
        listOne.add(R.drawable.img1)
        listOne.add(R.drawable.img2)

        val imageList = ArrayList<SlideModel>() // Create image list

// imageList.add(SlideModel("String Url" or R.drawable)
// imageList.add(SlideModel("String Url" or R.drawable, "title") You can add title

        imageList.add(
            SlideModel(
                "https://bit.ly/2YoJ77H",
                "The animal population decreased by 58 percent in 42 years."
            )
        )
        imageList.add(
            SlideModel(
                "https://bit.ly/2BteuF2",
                "Elephants and tigers may become extinct."
            )
        )
        imageList.add(SlideModel("https://bit.ly/3fLJf72", "And people do that."))
        binding.imageSliderHF.setImageList(imageList)


// FIT, CENTER_CROP or CENTER_INSIDE

        val imageListOne = ArrayList<SlideModel>() // Create image list


        imageListOne.add(
            SlideModel(R.drawable.img1, ScaleTypes.FIT) // for one image

        )
        // imageSlider . setImageList (imageList, ScaleTypes.FIT
        binding.imageSliderHF.setImageList(imageList, ScaleTypes.FIT)

        // for all images

        val adapter = CategoryAdapter(categoryList, categoryNameList)
        binding.rvCategory.layoutManager =
            LinearLayoutManager(view.context, LinearLayoutManager.HORIZONTAL, false)
        binding.rvCategory.adapter = adapter

        val productAdapter = ProductAdapter(recentProductList)
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