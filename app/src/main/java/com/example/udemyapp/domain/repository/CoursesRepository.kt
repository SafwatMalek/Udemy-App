package com.example.udemyapp.domain.repository

import com.example.udemyapp.data.course.CoursesResponse
import com.example.udemyapp.data.course.Results

interface CoursesRepository {

    suspend fun getCoursesList(): CoursesResponse
}