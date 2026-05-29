package com.example.mvvmpractice.mvvm_clean_xml_live_data.data.repository

import android.util.Log
import com.example.mvvmpractice.mvvm_clean_xml_live_data.data.mapper.toDomain
import com.example.mvvmpractice.mvvm_clean_xml_live_data.data.remote.OMDBAPIService
import com.example.mvvmpractice.mvvm_clean_xml_live_data.domain.model.Movie
import com.example.mvvmpractice.mvvm_clean_xml_live_data.domain.repository.MovieRepository
import com.example.mvvmpractice.mvvm_xml_live_data.utils.ApiConstants
import com.example.mvvmpractice.mvvm_xml_live_data.utils.ApiConstants.API_KEY
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val apiService: OMDBAPIService
) : MovieRepository {

    override suspend fun searchMovies(
        query: String
    ): List<Movie> {
        Log.d(ApiConstants.TAG, "MovieRepositoryImpl called")
        return apiService
            .searchMovies(query)
            .search
            .map {
                it.toDomain()
            }
    }
}