package com.example.udemyapp.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.udemyapp.data.api.UdemyAPI
import com.example.udemyapp.data.course.CoursesCategoryType
import com.example.udemyapp.data.course.CoursesResponse
import com.example.udemyapp.data.course.Results
import com.example.udemyapp.data.dataSource.CoursesDataSource
import com.example.udemyapp.domain.repository.CoursesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CoursesRepositoryImp @Inject constructor(private val udemyAPI: UdemyAPI) : CoursesRepository {


    override suspend fun getCoursesList(pageSize: Int, category: String?): CoursesResponse {
        return udemyAPI.getCourses(category = category, pageSize = pageSize)
    }

    override suspend fun getCoursesListCategory(category: String): Flow<PagingData<Results>> {
        return Pager(
            config = PagingConfig(pageSize = 10, enablePlaceholders = false),
            pagingSourceFactory = { CoursesDataSource(udemyAPI, category) }
        ).flow
    }

    override suspend fun getCoursesCategory(): List<String> {
        val categories = ArrayList<String>()
        CoursesCategoryType.values().toList().forEach {
            categories.add(it.value)
        }
        return categories
    }

    override suspend fun getCourseDetails(courseId: String): Results {
        return udemyAPI.getCourseDetails(courseId)
    }
}