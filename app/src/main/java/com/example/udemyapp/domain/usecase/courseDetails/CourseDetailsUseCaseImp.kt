package com.example.udemyapp.domain.usecase.courseDetails

import com.example.udemyapp.data.course.CoursesCategoryType
import com.example.udemyapp.data.course.Results
import com.example.udemyapp.domain.repository.CoursesRepository
import javax.inject.Inject

class CourseDetailsUseCaseImp @Inject constructor(private val courseRepo: CoursesRepository) :
    CourseDetailsUseCase {

    override suspend fun getCourseDetails(courseId: String): Results {
        return  courseRepo.getCourseDetails(courseId)
    }

}