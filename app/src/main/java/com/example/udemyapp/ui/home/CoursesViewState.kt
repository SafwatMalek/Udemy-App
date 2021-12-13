package com.example.udemyapp.ui.home

import com.example.udemyapp.data.course.Results

sealed class CoursesViewState {

    class CoursesList(
        val businessList: List<Results>,
        val designList: List<Results>,
        val developmentList: List<Results>,
        val categories: List<String>
    ) : CoursesViewState()

    class Loading(val isLong: Boolean) : CoursesViewState()
}