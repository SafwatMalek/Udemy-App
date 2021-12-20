package com.example.udemyapp.domain.usecase.courseReviews

import com.example.udemyapp.data.review.Review
import com.example.udemyapp.domain.repository.CoursesRepository
import javax.inject.Inject

class CourseReviewsUseCaseImp @Inject constructor(private val courseRepo: CoursesRepository) :
    CourseReviewsUseCase {

    override suspend fun getReviews(courseId: String): List<Review> {
        return courseRepo.getReviews(courseId).results?.filter {
            it.content.isNotEmpty()
        } ?: emptyList()
    }

}