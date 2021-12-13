package com.example.udemyapp.domain.repository

import com.example.udemyapp.data.course.CoursesResponse

interface CoursesRepository {

    suspend fun getBusinessCoursesList(pageSize: Int):CoursesResponse
}