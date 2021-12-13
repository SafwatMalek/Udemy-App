package com.example.udemyapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
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
        homeViewModel.internalState.observe(viewLifecycleOwner, {
            renderView(it)
        })
        if (homeViewModel.internalState.value == null) {
            homeViewModel.getCoursesList()
        }
    }


    private fun renderView(viewState: CoursesViewState) {
        when (viewState) {
            is CoursesViewState.BusinessList.Success -> {
                val adapter = CourseAdapter(viewState.businessList)
                homeViewBindings.rvBusiness.layoutManager = LinearLayoutManager(
                    requireContext(),
                    LinearLayoutManager.HORIZONTAL,
                    false
                )

                homeViewBindings.rvBusiness.adapter = adapter
            }
            is CoursesViewState.BusinessList.Failure -> {
                Toast.makeText(requireContext(), "error occurred", Toast.LENGTH_SHORT).show()
            }
            is CoursesViewState.DesignList.Success -> {
                val adapter = CourseAdapter(viewState.designList)
                homeViewBindings.rvDesign.layoutManager = LinearLayoutManager(
                    requireContext(),
                    LinearLayoutManager.HORIZONTAL,
                    false
                )

                homeViewBindings.rvDesign.adapter = adapter
            }


        }

    }


}