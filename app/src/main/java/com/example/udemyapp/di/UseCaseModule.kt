package com.example.udemyapp.di

import com.example.udemyapp.domain.usecase.courseDetails.CourseDetailsUseCase
import com.example.udemyapp.domain.usecase.courseDetails.CourseDetailsUseCaseImp
import com.example.udemyapp.domain.usecase.courseList.business.BusinessCourseListUseCase
import com.example.udemyapp.domain.usecase.courseList.business.BusinessCourseListUseCaseImp
import com.example.udemyapp.domain.usecase.courseList.category.CategoryUseCase
import com.example.udemyapp.domain.usecase.courseList.category.CategoryUseCaseImp
import com.example.udemyapp.domain.usecase.courseList.design.DesignCourseListUseCase
import com.example.udemyapp.domain.usecase.courseList.design.DesignCourseListUseCaseImp
import com.example.udemyapp.domain.usecase.courseList.development.DevelopmentCourseListUseCase
import com.example.udemyapp.domain.usecase.courseList.development.DevelopmentCourseListUseCaseImp
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
    abstract fun provideCourseListUseCase(courseListUseCase: BusinessCourseListUseCaseImp): BusinessCourseListUseCase

    @Binds
    @ViewModelScoped
    abstract fun provideCourseDesignListUseCase(designCourseListUseCase: DesignCourseListUseCaseImp): DesignCourseListUseCase

    @Binds
    @ViewModelScoped
    abstract fun provideCourseDevelopmentListUseCase(developmentCourseListUseCase: DevelopmentCourseListUseCaseImp): DevelopmentCourseListUseCase

    @Binds
    @ViewModelScoped
    abstract fun provideCourseCategoryListUseCase(categoryUseCase: CategoryUseCaseImp): CategoryUseCase

    @Binds
    @ViewModelScoped
    abstract fun ProvideCourseDtailsUseCase(courseDetailsUseCase: CourseDetailsUseCaseImp): CourseDetailsUseCase


}