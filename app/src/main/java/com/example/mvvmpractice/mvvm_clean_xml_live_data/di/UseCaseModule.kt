package com.example.mvvmpractice.mvvm_clean_xml_live_data.di

import com.example.mvvmpractice.mvvm_clean_xml_live_data.domain.repository.MovieRepository
import com.example.mvvmpractice.mvvm_clean_xml_live_data.domain.usecase.SearchMoviesUseCase
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @Provides
    fun provideSearchMoviesUseCase(
        repository: MovieRepository
    ): SearchMoviesUseCase {

        return SearchMoviesUseCase(
            repository
        )
    }
}