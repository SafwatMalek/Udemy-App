package com.example.udemyapp.ui.categoryList

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.udemyapp.domain.usecase.courseList.coursesByCategory.CoursesByCategoryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class CategoriesViewModel @Inject constructor(
    private val coursesByCategoryUseCase: CoursesByCategoryUseCase
) : ViewModel() {

    private val handleException = CoroutineExceptionHandler { _, throwable ->
        when (throwable) {
            is HttpException -> {
                if (throwable.code() in 400 until 500) {
                    //print message
                } else if (throwable.code() in 500 until 600) {
                    //print server down
                } else {
                    // un known error
                }
            }
            is IOException -> {
                println("please check internet connection : ${throwable.message}")
            }
        }
    }
    val viewState = MutableLiveData<CourseCategoriseViewState>()


    fun getCourses(category: String) {
        viewState.value = CourseCategoriseViewState.Loading(true)

        viewModelScope.launch(Dispatchers.IO + handleException) {
            val courses = coursesByCategoryUseCase
                .getCoursesByCategory(category)
                .cachedIn(viewModelScope)

            withContext(Dispatchers.Main) {
                viewState.value = CourseCategoriseViewState.Loading(false)
                courses.collectLatest {
                    viewState.value = CourseCategoriseViewState.Success(it)
                }
            }
        }
    }


}