package com.example.udemyapp.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.udemyapp.R
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
        action()
    }

    private fun initView(course: Results) {
        course.image_480x270.let {
            detailsView.ivCourseImage.clipToOutline = true
            detailsView.ivCourseImage.clipToOutline = true
            Glide.with(requireContext())
                .load(it)
                .into(detailsView.ivCourseImage)
        }
        course.title.let { detailsView.tvCourseTitle.text = it }
        course.headline.let { detailsView.tvCourseDescription.text = it }
        course.avg_rating.let { detailsView.rbCourse.rating = it?.toFloat() ?: 0f }
        course.getInstructorsNames().let {
            detailsView.tvInstructorName.text = getString(R.string.details_created_by, it)
        }

    }


    private fun action() {
        detailsView.toolbar.ivBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }

}