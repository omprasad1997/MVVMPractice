package com.example.mvvmpractice.mvvm_clean_xml_live_data.di

import com.example.mvvmpractice.mvvm_clean_xml_live_data.data.repository.MovieRepositoryImpl
import com.example.mvvmpractice.mvvm_clean_xml_live_data.domain.repository.MovieRepository
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryModule {

    @Binds
    abstract fun bindMovieRepository(
        impl: MovieRepositoryImpl
    ): MovieRepository
}