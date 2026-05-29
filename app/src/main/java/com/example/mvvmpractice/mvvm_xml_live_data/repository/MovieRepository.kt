package com.example.mvvmpractice.mvvm_xml_live_data.repository

import android.util.Log
import com.example.mvvmpractice.mvvm_xml_live_data.model.MovieResponse
import com.example.mvvmpractice.mvvm_xml_live_data.network.OMDBAPIService
import com.example.mvvmpractice.mvvm_xml_live_data.utils.ApiConstants
import javax.inject.Inject

class MovieRepository @Inject constructor(private val apiService: OMDBAPIService) {
    suspend fun searchMovies(searchTerm: String): MovieResponse {

        val movieResponse = apiService.searchMovies(searchTerm)
        Log.d(ApiConstants.TAG, "MovieRepository ${movieResponse.Search[0].Title}" )
        return movieResponse
    }
}