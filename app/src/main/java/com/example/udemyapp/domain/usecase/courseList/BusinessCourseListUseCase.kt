package com.example.udemyapp.domain.usecase.courseList

import com.example.udemyapp.data.course.Results

interface BusinessCourseListUseCase {
    suspend fun getBusinessCourseList(pageSize: Int): List<Results>
}