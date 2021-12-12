package com.example.udemyapp.di

import com.example.udemyapp.data.repository.CoursesRepositoryImp
import com.example.udemyapp.domain.repository.CoursesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {

    @Binds
    @ViewModelScoped
    abstract fun provideMovieRepos(coursesRepositoryImp: CoursesRepositoryImp): CoursesRepository
}