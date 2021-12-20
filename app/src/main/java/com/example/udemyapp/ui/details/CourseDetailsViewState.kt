package com.example.udemyapp.ui.details

import com.example.udemyapp.data.course.Results
import com.example.udemyapp.data.review.Review

sealed class CourseDetailsViewState {
    class CourseDetails(
        val details: Results,
        val reviews: List<Review>
    ) : CourseDetailsViewState()

    class Loading(val isLoading: Boolean) : CourseDetailsViewState()
}