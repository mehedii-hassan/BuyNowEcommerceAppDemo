package com.example.buynowecommerceapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.buynowecommerceapp.databinding.CategoryRowItemDesignBinding
import com.example.buynowecommerceapp.databinding.RvFeatureProductsItemDesignBinding
import com.example.buynowecommerceapp.databinding.RvShopNowItemDesignBinding

class PopularProductAdapter(
    private val featureProductImageList: ArrayList<Int>,
) :
    RecyclerView.Adapter<PopularProductAdapter.PopularProductViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularProductViewHolder {
        val binding = RvFeatureProductsItemDesignBinding.inflate(
            LayoutInflater
                .from(parent.context), parent, false
        )
        return PopularProductViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return featureProductImageList.size
    }

    override fun onBindViewHolder(holder: PopularProductViewHolder, position: Int) {

        holder.bind(position)
    }


    inner class PopularProductViewHolder(private val binding: RvFeatureProductsItemDesignBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(position: Int) {
            binding.ivFeatureProductItem.setImageResource(featureProductImageList[position])


        }
    }
}