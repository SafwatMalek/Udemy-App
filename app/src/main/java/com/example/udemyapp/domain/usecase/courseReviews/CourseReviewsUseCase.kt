package com.example.udemyapp.domain.usecase.courseReviews


import com.example.udemyapp.data.review.Review

interface CourseReviewsUseCase {
    suspend fun getReviews(courseId: String): List<Review>
}