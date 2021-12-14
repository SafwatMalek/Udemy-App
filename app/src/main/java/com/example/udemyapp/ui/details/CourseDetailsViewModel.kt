package com.example.udemyapp.ui.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.udemyapp.domain.usecase.courseDetails.CourseDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


@HiltViewModel
class CourseDetailsViewModel @Inject constructor(
    val courseDetailsUseCase: CourseDetailsUseCase
) : ViewModel() {

    fun getCourseDetails(courseId: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val courseDetails = async { courseDetailsUseCase.getCourseDetails(courseId) }.await()
            withContext(Dispatchers.Main) {
                print("courseDetails: $courseDetails")
            }
        }
    }

}