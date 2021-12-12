package com.example.udemyapp.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.udemyapp.domain.usecase.courseList.CourseListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(val courseListUseCase: CourseListUseCase) : ViewModel() {

    fun getCoursesList() {
        try {
            viewModelScope.launch {
                val list = courseListUseCase.getCoursesList()
                print("List Of Course $list")
            }
        } catch (e: Exception) {
            print("exception occurred : $e")
        }
    }

}