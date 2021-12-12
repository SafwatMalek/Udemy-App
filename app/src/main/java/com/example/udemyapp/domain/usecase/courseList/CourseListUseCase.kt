package com.example.udemyapp.domain.usecase.courseList

import com.example.udemyapp.data.course.Results

interface CourseListUseCase {
    suspend fun getCoursesList(): List<Results>
}