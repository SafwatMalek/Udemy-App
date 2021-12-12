package com.example.udemyapp.domain.usecase.courseList

import com.example.udemyapp.data.course.Results
import com.example.udemyapp.domain.repository.CoursesRepository
import javax.inject.Inject

class CourseListUseCaseImp @Inject constructor(val courseRepo: CoursesRepository) :
    CourseListUseCase {

    override suspend fun getCoursesList(): List<Results> {
        return courseRepo.getCoursesList().results ?: kotlin.run {
            emptyList()
        }
    }
}