package com.example.udemyapp.domain.usecase.courseDetails


import com.example.udemyapp.data.course.Results

interface CourseDetailsUseCase {
    suspend fun getCourseDetails(courseId:String): Results
}