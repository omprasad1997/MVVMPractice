package com.example.mvvmpractice.mvvm_clean_xml_live_data.di

import com.example.mvvmpractice.mvvm_xml_live_data.utils.ApiConstants
import com.example.mvvmpractice.mvvm_clean_xml_live_data.data.remote.OMDBAPIService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(ApiConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideOMDBAPIService(retrofit: Retrofit): OMDBAPIService {
        return retrofit.create(OMDBAPIService::class.java)
    }
}
