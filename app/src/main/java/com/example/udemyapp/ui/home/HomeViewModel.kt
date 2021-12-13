package com.example.udemyapp.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.udemyapp.data.course.Results
import com.example.udemyapp.domain.usecase.courseList.business.BusinessCourseListUseCase
import com.example.udemyapp.domain.usecase.courseList.design.DesignCourseListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val businessCourseListUseCase: BusinessCourseListUseCase,
    private val designCourseListUseCase: DesignCourseListUseCase
) :
    ViewModel() {

    private val viewState = MutableLiveData<CoursesViewState>()
    val internalState = viewState


    fun getCoursesList() {
        try {
            viewModelScope.launch {
                val business = async {
                    getBusinessList()
                }
                val design = async {
                    getTopDesign()
                }

                viewState.value = CoursesViewState.BusinessList.Success(business.await())
                viewState.value = CoursesViewState.DesignList.Success(design.await())
            }
        } catch (e: Exception) {
            print("exception occurred : $e")
        }
    }

    private suspend fun getBusinessList(): List<Results> {
        return businessCourseListUseCase.getBusinessCourseList(pageSize = 6)
    }

    private suspend fun getTopDesign(): List<Results> {
        return designCourseListUseCase.getDesignCourseList(pageSize = 6)
    }

    suspend fun getTopDevelopment() {}
    suspend fun getTopITSoftware() {}
    suspend fun getTopPersonalDevelopment() {}
}