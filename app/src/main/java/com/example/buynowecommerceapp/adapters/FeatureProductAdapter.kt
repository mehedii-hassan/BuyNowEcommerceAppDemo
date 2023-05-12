package com.example.buynowecommerceapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.buynowecommerceapp.databinding.CategoryRowItemDesignBinding
import com.example.buynowecommerceapp.databinding.RvFeatureProductsItemDesignBinding
import com.example.buynowecommerceapp.databinding.RvShopNowItemDesignBinding

class FeatureProductAdapter(
    private val featureProductImageList: ArrayList<Int>,
) :
    RecyclerView.Adapter<FeatureProductAdapter.FeatureProductViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeatureProductViewHolder {
        val binding = RvFeatureProductsItemDesignBinding.inflate(
            LayoutInflater
                .from(parent.context), parent, false
        )
        return FeatureProductViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return featureProductImageList.size
    }

    override fun onBindViewHolder(holder: FeatureProductViewHolder, position: Int) {

        holder.bind(position)
    }


    inner class FeatureProductViewHolder(private val binding: RvFeatureProductsItemDesignBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(position: Int) {
            binding.ivFeatureProductItem.setImageResource(featureProductImageList[position])


        }
    }
}