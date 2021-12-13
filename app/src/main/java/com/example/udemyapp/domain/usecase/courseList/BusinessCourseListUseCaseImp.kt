package com.example.udemyapp.domain.usecase.courseList

import com.example.udemyapp.data.course.Results
import com.example.udemyapp.domain.repository.CoursesRepository
import javax.inject.Inject

class BusinessCourseListUseCaseImp @Inject constructor(private val courseRepo: CoursesRepository) :
    BusinessCourseListUseCase {

    override suspend fun getBusinessCourseList(pageSize: Int): List<Results> {
        return courseRepo.getBusinessCoursesList(pageSize).results ?: kotlin.run {
            emptyList()
        }
    }
}