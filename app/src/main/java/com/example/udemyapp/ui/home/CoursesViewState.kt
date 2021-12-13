package com.example.udemyapp.ui.home

import com.example.udemyapp.data.course.Results

sealed class CoursesViewState {
    sealed class BusinessList {
        class Success(val businessList: List<Results>) : CoursesViewState()
        object Failure : CoursesViewState()
    }
    sealed class DesignList {
        class Success(val designList: List<Results>) : CoursesViewState()
        object Failure : CoursesViewState()
    }
}