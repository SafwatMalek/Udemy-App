package com.example.udemyapp.domain.usecase.courseList.category

import com.example.udemyapp.domain.repository.CoursesRepository
import javax.inject.Inject

class CategoryUseCaseImp @Inject constructor(private val courseRepo: CoursesRepository) :
    CategoryUseCase {

    override suspend fun getCategory(): List<String> {
        return courseRepo.getCoursesCategory()
    }
}