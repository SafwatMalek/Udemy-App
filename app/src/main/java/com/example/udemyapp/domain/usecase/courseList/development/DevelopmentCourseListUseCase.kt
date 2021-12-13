package com.example.udemyapp.domain.usecase.courseList.development


import com.example.udemyapp.data.course.Results

interface DevelopmentCourseListUseCase {
    suspend fun getDevelopmentCourses(pageSize: Int): List<Results>
}