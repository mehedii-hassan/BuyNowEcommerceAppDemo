package com.example.buynowecommerceapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.buynowecommerceapp.databinding.CategoryRowItemDesignBinding

class CategoryAdapter(
    private val categoryImageList: ArrayList<Int>,
    private val categoryNameList: Array<String>
) :
    RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val binding = CategoryRowItemDesignBinding.inflate(
            LayoutInflater
                .from(parent.context), parent, false
        )
        return CategoryViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return categoryImageList.size
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {

        holder.bind(position)
    }


    inner class CategoryViewHolder(private val binding: CategoryRowItemDesignBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(position: Int) {
            // binding.ivCategoryItem.setImageResource(categoryImageList[position])
            binding.tvCategoryName.text = categoryNameList[position]
            binding.ivCategoryItem.setImageResource(categoryImageList[position])


        }
    }
}