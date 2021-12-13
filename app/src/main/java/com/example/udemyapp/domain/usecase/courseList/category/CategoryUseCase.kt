package com.example.udemyapp.domain.usecase.courseList.category

import com.example.udemyapp.data.course.Results

interface CategoryUseCase {
    suspend fun getCategory(): List<String>
}