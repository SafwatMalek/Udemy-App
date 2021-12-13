package com.example.udemyapp.data.repository

import com.example.udemyapp.data.api.UdemyAPI
import com.example.udemyapp.data.course.CoursesResponse
import com.example.udemyapp.domain.repository.CoursesRepository
import javax.inject.Inject

class CoursesRepositoryImp @Inject constructor(val udemyAPI: UdemyAPI) : CoursesRepository {


    override suspend fun getBusinessCoursesList(pageSize: Int): CoursesResponse {
        return udemyAPI.getCourses(category = "Business", pageSize = pageSize)
    }


}