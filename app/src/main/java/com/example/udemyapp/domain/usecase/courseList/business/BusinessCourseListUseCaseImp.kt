package com.example.udemyapp.domain.usecase.courseList.business

import com.example.udemyapp.data.course.CoursesCategoryType
import com.example.udemyapp.data.course.Results
import com.example.udemyapp.domain.repository.CoursesRepository
import javax.inject.Inject

class BusinessCourseListUseCaseImp @Inject constructor(private val courseRepo: CoursesRepository) :
    BusinessCourseListUseCase {

    override suspend fun getBusinessCourseList(pageSize: Int): List<Results> {
        return courseRepo.getCoursesList(pageSize,CoursesCategoryType.Business.value).results ?: kotlin.run {
            emptyList()
        }
    }
}