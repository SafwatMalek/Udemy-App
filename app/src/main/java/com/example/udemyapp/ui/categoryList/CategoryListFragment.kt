package com.example.udemyapp.ui.categoryList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.udemyapp.databinding.FragmentCategoryListBinding


class CategoryListFragment : Fragment() {
    lateinit var categoryView: FragmentCategoryListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        categoryView = FragmentCategoryListBinding.inflate(inflater, container, false)
        return categoryView.root
    }


}