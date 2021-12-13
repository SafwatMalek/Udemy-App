package com.example.udemyapp.domain.usecase.courseList.design

import com.example.udemyapp.data.course.CoursesCategoryType
import com.example.udemyapp.data.course.Results
import com.example.udemyapp.domain.repository.CoursesRepository
import javax.inject.Inject

class DesignCourseListUseCaseImp @Inject constructor(private val courseRepo: CoursesRepository) :
    DesignCourseListUseCase {

    override suspend fun getDesignCourseList(pageSize: Int): List<Results> {
        return courseRepo.getCoursesList(pageSize, CoursesCategoryType.Design.value).results
            ?: kotlin.run {
                emptyList()
            }
    }
}