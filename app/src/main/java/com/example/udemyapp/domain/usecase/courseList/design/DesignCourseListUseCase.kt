package com.example.udemyapp.domain.usecase.courseList.design

import com.example.udemyapp.data.course.Results

interface DesignCourseListUseCase {
    suspend fun getDesignCourseList(pageSize: Int): List<Results>
}