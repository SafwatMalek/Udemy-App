package com.example.udemyapp.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.udemyapp.data.course.Results
import com.example.udemyapp.domain.usecase.courseList.business.BusinessCourseListUseCase
import com.example.udemyapp.domain.usecase.courseList.design.DesignCourseListUseCase
import com.example.udemyapp.domain.usecase.courseList.development.DevelopmentCourseListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val businessCourseListUseCase: BusinessCourseListUseCase,
    private val designCourseListUseCase: DesignCourseListUseCase,
    private val developmentCourseListUseCase: DevelopmentCourseListUseCase
) : ViewModel() {

    private val viewState = MutableLiveData<CoursesViewState>()
    val internalState = viewState


    fun getCoursesList() {
        try {
            viewState.value = CoursesViewState.Loading(true)
            viewModelScope.launch(Dispatchers.IO) {
                supervisorScope {
                    val business = async(Dispatchers.IO) {
                        getBusinessList()
                    }.await()
                    val design = async(Dispatchers.IO) {
                        getTopDesign()
                    }.await()
                    val development = async(Dispatchers.IO) {
                        getTopDevelopment()
                    }.await()

                    withContext(Dispatchers.Main) {
                        viewState.value = CoursesViewState.Loading(false)
                        viewState.value = CoursesViewState.CoursesList(
                            business,
                            design,
                            development
                        )
                    }
                }
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

    private suspend fun getTopDevelopment(): List<Results> {
        return developmentCourseListUseCase.getDevelopmentCourses(pageSize = 6)
    }

    suspend fun getTopITSoftware() {}
    suspend fun getTopPersonalDevelopment() {}
}