package com.example.udemyapp.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.udemyapp.data.course.Results
import com.example.udemyapp.databinding.FragmentDetailsBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class DetailsFragment : Fragment() {
    private val argument: DetailsFragmentArgs by navArgs()
    private val detailsVM: CourseDetailsViewModel by viewModels()

    lateinit var detailsView: FragmentDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        detailsView = FragmentDetailsBinding.inflate(inflater, container, false)
        return detailsView.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        argument.course?.let {
            initView(it)
        } ?: kotlin.run {

        }
    }

    private fun initView(course: Results) {

    }

}