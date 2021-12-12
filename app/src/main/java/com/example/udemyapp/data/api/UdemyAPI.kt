package com.example.udemyapp.data.api

import com.example.udemyapp.data.course.CoursesResponse
import retrofit2.http.GET

interface UdemyAPI {

    @GET("api-2.0/courses/")
    suspend fun getCourses(): CoursesResponse
}