package com.example.udemyapp.ui.details

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.udemyapp.domain.usecase.courseDetails.CourseDetailsUseCase
import com.example.udemyapp.domain.usecase.courseReviews.CourseReviewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


@HiltViewModel
class CourseDetailsViewModel @Inject constructor(
    private val courseDetailsUseCase: CourseDetailsUseCase,
    private val reviewsUseCase: CourseReviewsUseCase
) : ViewModel() {

    private val viewState = MutableLiveData<CourseDetailsViewState>()
    val internalState = viewState

    fun getCourseDetails(courseId: String) {
        viewState.value = CourseDetailsViewState.Loading(true)

        viewModelScope.launch(Dispatchers.IO) {
            val courseDetailsDeferred = async { courseDetailsUseCase.getCourseDetails(courseId) }
            val courseReviewsDeferred = async { reviewsUseCase.getReviews(courseId) }

            val courseDetails = courseDetailsDeferred.await()
            val courseReviews = courseReviewsDeferred.await()

            withContext(Dispatchers.Main) {
                viewState.value = CourseDetailsViewState.Loading(false)
                viewState.value = CourseDetailsViewState.CourseDetails(
                    details = courseDetails,
                    reviews = courseReviews
                )
            }
        }
    }

}