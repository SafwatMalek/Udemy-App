package com.example.udemyapp.ui.categoryList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.udemyapp.data.course.Results
import com.example.udemyapp.databinding.FragmentCategoryListBinding
import com.example.udemyapp.ui.categoryList.adapter.CoursesCategoriseAdapter
import com.example.udemyapp.utils.setVisibility
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class CategoryListFragment : Fragment() {
    private val categoryVM: CategoriesViewModel by viewModels()
    private val args: CategoryListFragmentArgs by navArgs()
    private val adapter: CoursesCategoriseAdapter by lazy {
        CoursesCategoriseAdapter(this::courseDetailsAction)
    }
    private lateinit var categoryView: FragmentCategoryListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        categoryView = FragmentCategoryListBinding.inflate(inflater, container, false)
        return categoryView.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        actions()
        categoryVM.viewState.observe(viewLifecycleOwner, {
            renderView(it)
        })
        if ((categoryVM.viewState.value is CourseCategoriseViewState.Success).not()) {
            categoryVM.getCourses(args.categoryName)
        }

    }

    private fun initView() {
        categoryView.toolbar.tvActionBarTitle.text = args.categoryName
        categoryView.rvCoursesCategory.adapter = adapter
    }

    private fun renderView(viewState: CourseCategoriseViewState) {
        when (viewState) {
            is CourseCategoriseViewState.Loading -> {
                categoryView.loader.setVisibility(viewState.show)
            }
            is CourseCategoriseViewState.Success -> {
                categoryView.rvCoursesCategory.visibility = View.VISIBLE
                lifecycleScope.launch {
                    adapter.submitData(viewState.courses)
                }
            }
        }
    }

    private fun actions() {
        categoryView.toolbar.ivBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }


    private fun courseDetailsAction(course: Results) {
        val action = CategoryListFragmentDirections.categoryListFragmentToDetailsFragment(course)
        findNavController().navigate(action)
    }
}