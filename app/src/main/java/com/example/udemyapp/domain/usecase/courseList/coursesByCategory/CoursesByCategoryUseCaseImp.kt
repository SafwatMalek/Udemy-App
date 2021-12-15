package com.example.udemyapp.domain.usecase.courseList.coursesByCategory

import androidx.paging.PagingData
import com.example.udemyapp.data.course.Results
import com.example.udemyapp.domain.repository.CoursesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CoursesByCategoryUseCaseImp @Inject constructor(private val courseRepo: CoursesRepository) :
    CoursesByCategoryUseCase {

    override suspend fun getCoursesByCategory(category: String): Flow<PagingData<Results>> {
        return courseRepo.getCoursesListCategory(category)
    }


}