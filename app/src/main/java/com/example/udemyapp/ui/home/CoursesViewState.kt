package com.example.udemyapp.ui.home

import com.example.udemyapp.data.course.Results

sealed class CoursesViewState {
    sealed class BusinessList {
        class Success(val businessList: List<Results>) : CoursesViewState()
        object Failure : CoursesViewState()
    }
}