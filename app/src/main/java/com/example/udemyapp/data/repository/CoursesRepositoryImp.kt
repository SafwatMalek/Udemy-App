package com.example.udemyapp.data.repository

import com.example.udemyapp.data.api.UdemyAPI
import com.example.udemyapp.data.course.CoursesCategoryType
import com.example.udemyapp.data.course.CoursesResponse
import com.example.udemyapp.domain.repository.CoursesRepository
import javax.inject.Inject

class CoursesRepositoryImp @Inject constructor(private val udemyAPI: UdemyAPI) : CoursesRepository {


    override suspend fun getCoursesList(pageSize: Int, category: String?): CoursesResponse {
        return udemyAPI.getCourses(category = category, pageSize = pageSize)
    }

    override suspend fun getCoursesCategory(): List<String> {
        val categories = ArrayList<String>()
        CoursesCategoryType.values().toList().forEach {
            categories.add(it.value)
        }
        return categories
    }


}