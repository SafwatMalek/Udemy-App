package com.example.udemyapp.ui.categoryList

import androidx.paging.PagingData
import com.example.udemyapp.data.course.Results

sealed class CourseCategoriseViewState {
    class Loading(val show: Boolean) : CourseCategoriseViewState()
    class Success(val courses: PagingData<Results> = PagingData.empty()) :
        CourseCategoriseViewState()
}