package com.example.udemyapp.domain.usecase.courseList.development

import com.example.udemyapp.data.course.CoursesCategoryType
import com.example.udemyapp.data.course.Results
import com.example.udemyapp.domain.repository.CoursesRepository
import javax.inject.Inject

class DevelopmentCourseListUseCaseImp @Inject constructor(private val courseRepo: CoursesRepository) :
    DevelopmentCourseListUseCase {

    override suspend fun getDevelopmentCourses(pageSize: Int): List<Results> {
        return courseRepo.getCoursesList(pageSize, CoursesCategoryType.Development.value).results
            ?: kotlin.run {
                emptyList()
            }
    }
}