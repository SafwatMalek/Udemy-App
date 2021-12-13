package com.example.udemyapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
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
        if (homeViewModel.internalState.value == null) {
            homeViewModel.internalState.observe(viewLifecycleOwner, {
                renderView(it)
            })
            homeViewModel.getCoursesList()
        }
    }


    private fun renderView(viewState: CoursesViewState) {
        when (viewState) {
            is CoursesViewState.CoursesList -> {
                val businessLayoutManager = LinearLayoutManager(
                    requireContext(),
                    LinearLayoutManager.HORIZONTAL,
                    false
                )
                val designLayoutManager = LinearLayoutManager(
                    requireContext(),
                    LinearLayoutManager.HORIZONTAL,
                    false
                )
                val developmentLayoutManager = LinearLayoutManager(
                    requireContext(),
                    LinearLayoutManager.HORIZONTAL,
                    false
                )

                homeViewBindings.rvBusiness.layoutManager = businessLayoutManager
                homeViewBindings.rvDesign.layoutManager = designLayoutManager
                homeViewBindings.rvDevelopment.layoutManager = developmentLayoutManager


                val businessAdapter = CourseAdapter(viewState.businessList)
                homeViewBindings.rvBusiness.adapter = businessAdapter

                val designAdapter = CourseAdapter(viewState.designList)
                homeViewBindings.rvDesign.adapter = designAdapter

                val developmentAdapter = CourseAdapter(viewState.developmentList)
                homeViewBindings.rvDevelopment.adapter = developmentAdapter
            }
        }

    }


}