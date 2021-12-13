package com.example.udemyapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.udemyapp.data.course.Results
import com.example.udemyapp.databinding.FragmentHomeBinding
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
        if (homeViewModel.internalState.value == null) {
            homeViewModel.getCoursesList()
        }
    }


    private fun renderView(viewState: CoursesViewState) {
        when (viewState) {
            is CoursesViewState.CoursesList -> {
                initBusinessList(viewState.businessList)
                initDesignList(viewState.designList)
                initDevelopmentList(viewState.developmentList)
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
            val businessAdapter = CourseAdapter(businessList)
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
            val designAdapter = CourseAdapter(designList)
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


            val developmentAdapter = CourseAdapter(developmentList)
            homeViewBindings.rvDevelopment.adapter = developmentAdapter
        }
    }

}