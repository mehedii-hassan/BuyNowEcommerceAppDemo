package com.example.buynowecommerceapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.buynowecommerceapp.databinding.CategoryRowItemDesignBinding
import com.example.buynowecommerceapp.databinding.RvShopNowItemDesignBinding

class ShopNowAdapter(
    private val shopNowImageList: ArrayList<Int>,
) :
    RecyclerView.Adapter<ShopNowAdapter.ShopNowViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopNowViewHolder {
        val binding = RvShopNowItemDesignBinding.inflate(
            LayoutInflater
                .from(parent.context), parent, false
        )
        return ShopNowViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return shopNowImageList.size
    }

    override fun onBindViewHolder(holder: ShopNowViewHolder, position: Int) {

        holder.bind(position)
    }


    inner class ShopNowViewHolder(private val binding: RvShopNowItemDesignBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(position: Int) {
            binding.ivShopNowItem.setImageResource(shopNowImageList[position])


        }
    }
}