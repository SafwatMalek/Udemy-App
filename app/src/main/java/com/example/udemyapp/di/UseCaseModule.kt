package com.example.udemyapp.di

import com.example.udemyapp.domain.usecase.courseList.CourseListUseCase
import com.example.udemyapp.domain.usecase.courseList.CourseListUseCaseImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class UseCaseModule {

    @Binds
    @ViewModelScoped
    abstract fun provideCourseListUseCase(courseListUseCase: CourseListUseCaseImp): CourseListUseCase


}