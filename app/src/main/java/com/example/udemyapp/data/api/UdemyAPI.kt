package com.example.udemyapp.data.api

import com.example.udemyapp.data.course.CoursesResponse
import com.example.udemyapp.data.course.Results
import com.example.udemyapp.data.review.Review
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface UdemyAPI {

    @GET("api-2.0/courses/")
    suspend fun getCourses(
        @Query("page") page: Int? = 1,
        @Query("page_size") pageSize: Int = 12,
        @Query("category") category: String?
    ): CoursesResponse<Results>


    @GET("api-2.0/courses/{pk}/")
    suspend fun getCourseDetails(
        @Path("pk") courseId: String
    ): Results

    @GET("api-2.0/courses/{course_id}/reviews")
    suspend fun getReviews(
        @Path("course_id") courseId: String
    ): CoursesResponse<Review>


}