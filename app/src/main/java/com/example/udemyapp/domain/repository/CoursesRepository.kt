package com.example.udemyapp.domain.repository

import com.example.udemyapp.data.course.CoursesResponse
import com.example.udemyapp.data.course.Results

interface CoursesRepository {

    suspend fun getCoursesList(pageSize: Int, category: String?): CoursesResponse

    suspend fun getCoursesCategory(): List<String>

    suspend fun getCourseDetails(courseId: String): Results
}