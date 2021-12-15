package com.example.udemyapp.domain.usecase.courseList.coursesByCategory

import androidx.paging.PagingData
import com.example.udemyapp.data.course.Results
import kotlinx.coroutines.flow.Flow

interface CoursesByCategoryUseCase {
    suspend fun getCoursesByCategory(category: String): Flow<PagingData<Results>>
}