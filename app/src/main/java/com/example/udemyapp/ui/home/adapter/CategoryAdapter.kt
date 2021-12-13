package com.example.udemyapp.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.udemyapp.databinding.ItemCategoryBinding

class CategoryAdapter constructor(private val categories: List<String>) :
    RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    override fun getItemCount() = categories.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val movieViewHolder = ItemCategoryBinding.inflate(layoutInflater, parent, false)
        return CategoryViewHolder(movieViewHolder)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(categories[position])
    }


    inner class CategoryViewHolder(val view: ItemCategoryBinding) :
        RecyclerView.ViewHolder(view.root) {
        fun bind(category: String) {
            view.tvCategoryName.text = category
        }

    }

}