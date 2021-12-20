package com.example.udemyapp.domain.repository

import androidx.paging.PagingData
import com.example.udemyapp.data.course.CoursesResponse
import com.example.udemyapp.data.course.Results
import com.example.udemyapp.data.review.Review
import kotlinx.coroutines.flow.Flow

interface CoursesRepository {

    suspend fun getCoursesList(pageSize: Int, category: String?): CoursesResponse<Results>

    suspend fun getCoursesListCategory(category: String): Flow<PagingData<Results>>

    suspend fun getCoursesCategory(): List<String>

    suspend fun getCourseDetails(courseId: String): Results

    suspend fun getReviews(courseId: String): CoursesResponse<Review>

}