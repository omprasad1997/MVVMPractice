package com.example.mvvmpractice.repository

import android.util.Log
import com.example.mvvmpractice.model.MovieResponse
import com.example.mvvmpractice.network.OMDBAPIService
import com.example.mvvmpractice.utils.ApiConstants
import javax.inject.Inject

class MovieRepository @Inject constructor(private val apiService: OMDBAPIService) {
    suspend fun searchMovies(searchTerm: String): MovieResponse {

        val movieResponse = apiService.searchMovies(searchTerm)
        Log.d(ApiConstants.TAG, "MovieRepository ${movieResponse.Search[0].Title}" )
        return movieResponse
    }
}