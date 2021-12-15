package com.example.udemyapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.udemyapp.data.course.CoursesCategoryType
import com.example.udemyapp.data.course.Results
import com.example.udemyapp.databinding.FragmentHomeBinding
import com.example.udemyapp.ui.home.adapter.CategoryAdapter
import com.example.udemyapp.ui.home.adapter.CourseAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
    lateinit var homeViewBindings: FragmentHomeBinding
    private val homeViewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        homeViewBindings = FragmentHomeBinding.inflate(inflater, container, false)
        return homeViewBindings.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homeViewModel.internalState.observe(viewLifecycleOwner, {
            renderView(it)
        })
        if ((homeViewModel.internalState.value is CoursesViewState.CoursesList).not()) {
            homeViewModel.getCoursesList()
        }
    }


    private fun renderView(viewState: CoursesViewState) {
        when (viewState) {
            is CoursesViewState.CoursesList -> {
                initBusinessList(viewState.businessList)
                initDesignList(viewState.designList)
                initDevelopmentList(viewState.developmentList)
                initCategoryList(viewState.categories)
            }
            is CoursesViewState.Loading -> {
                homeViewBindings.loader.visibility = if (viewState.isLong) {
                    View.VISIBLE
                } else {
                    View.GONE
                }
            }
        }
    }

    private fun initBusinessList(businessList: List<Results>) {
        if (businessList.isNullOrEmpty()) {
            homeViewBindings.businessSection.visibility = View.GONE
        } else {
            homeViewBindings.businessSection.visibility = View.VISIBLE
            val businessLayoutManager = LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.HORIZONTAL,
                false
            )
            homeViewBindings.rvBusiness.layoutManager = businessLayoutManager
            val businessAdapter = CourseAdapter(
                businessList,
                CoursesCategoryType.Business,
                this::courseDetailsAction,
                this::seeAllAction
            )

            homeViewBindings.rvBusiness.adapter = businessAdapter
        }
    }

    private fun initDesignList(designList: List<Results>) {
        if (designList.isNullOrEmpty()) {
            homeViewBindings.designSection.visibility = View.GONE
        } else {
            homeViewBindings.designSection.visibility = View.VISIBLE
            val designLayoutManager = LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.HORIZONTAL,
                false
            )
            homeViewBindings.rvDesign.layoutManager = designLayoutManager
            val designAdapter = CourseAdapter(
                designList,
                CoursesCategoryType.Business,
                this::courseDetailsAction,
                this::seeAllAction
            )
            homeViewBindings.rvDesign.adapter = designAdapter
        }
    }

    private fun initDevelopmentList(developmentList: List<Results>) {
        if (developmentList.isNullOrEmpty()) {
            homeViewBindings.developmentSection.visibility = View.GONE
        } else {
            homeViewBindings.developmentSection.visibility = View.VISIBLE
            val developmentLayoutManager = LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.HORIZONTAL,
                false
            )

            homeViewBindings.rvDevelopment.layoutManager = developmentLayoutManager


            val developmentAdapter = CourseAdapter(
                developmentList,
                CoursesCategoryType.Business,
                this::courseDetailsAction,
                this::seeAllAction
            )
            homeViewBindings.rvDevelopment.adapter = developmentAdapter
        }
    }

    private fun initCategoryList(categories: List<String>) {
        if (categories.isNullOrEmpty()) {
            homeViewBindings.categorySection.visibility = View.GONE
        } else {
            homeViewBindings.categorySection.visibility = View.VISIBLE
            val categoryLayoutManager = GridLayoutManager(
                context, 2, GridLayoutManager.HORIZONTAL, false
            )

            homeViewBindings.rvCategory.layoutManager = categoryLayoutManager


            val developmentAdapter = CategoryAdapter(categories,this::seeAllAction)
            homeViewBindings.rvCategory.adapter = developmentAdapter
        }
    }

    private fun courseDetailsAction(course: Results) {
        val action = HomeFragmentDirections.homeFragmentToDetailsFragment(course)
        findNavController().navigate(action)
    }

    private fun seeAllAction(category: String) {
        val action = HomeFragmentDirections.homeFragmentToCategoryListFragment(category)
        findNavController().navigate(action)
    }
}