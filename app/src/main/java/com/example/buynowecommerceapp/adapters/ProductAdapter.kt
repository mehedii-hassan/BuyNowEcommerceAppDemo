package com.example.buynowecommerceapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.buynowecommerceapp.databinding.RvFeatureProductsItemDesignBinding

class ProductAdapter(
    private val productImageList: ArrayList<Int>,
) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding = RvFeatureProductsItemDesignBinding.inflate(
            LayoutInflater
                .from(parent.context), parent, false
        )
        return ProductViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return productImageList.size
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(position)
    }

    inner class ProductViewHolder(private val binding: RvFeatureProductsItemDesignBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(position: Int) {
            binding.ivFeatureProductItem.setImageResource(productImageList[position])
        }
    }
}