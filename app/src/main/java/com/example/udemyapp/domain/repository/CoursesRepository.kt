package com.example.udemyapp.domain.repository

import com.example.udemyapp.data.course.CoursesResponse

interface CoursesRepository {

    suspend fun getCoursesList(pageSize: Int, category: String?): CoursesResponse
}