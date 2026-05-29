package com.example.mvvmpractice.mvvm_xml_live_data.network

import com.example.mvvmpractice.mvvm_xml_live_data.model.MovieResponse
import com.example.mvvmpractice.mvvm_xml_live_data.utils.ApiConstants
import retrofit2.http.GET
import retrofit2.http.Query

interface OMDBAPIService {
    @GET("/")
    suspend fun searchMovies(
        @Query("s") searchTerm: String,
        @Query("apikey") apiKey: String = ApiConstants.API_KEY
    ): MovieResponse
}