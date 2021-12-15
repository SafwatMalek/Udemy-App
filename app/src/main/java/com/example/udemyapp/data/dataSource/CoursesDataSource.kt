package com.example.udemyapp.data.dataSource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.udemyapp.data.api.UdemyAPI
import com.example.udemyapp.data.course.Results

class CoursesDataSource constructor(private val udemyAPI: UdemyAPI, private val category: String) :
    PagingSource<Int, Results>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Results> {
        val position = params.key ?: 1
        return try {
            val response = udemyAPI.getCourses(page = position, category = category)
            print("paging thread ${Thread.currentThread().name}")

            response.results?.let {
                LoadResult.Page(
                    data = it,
                    prevKey = if (position == 0) null else position - 1,
                    nextKey = if (response.results.isEmpty()) null else position + 1
                )
            } ?: run {
                LoadResult.Error(java.lang.Exception("empty List"))
            }
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }


    override fun getRefreshKey(state: PagingState<Int, Results>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }
}