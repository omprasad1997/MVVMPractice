package com.example.mvvmpractice.network

import com.example.mvvmpractice.model.MovieResponse
import com.example.mvvmpractice.utils.ApiConstants
import retrofit2.http.GET
import retrofit2.http.Query

interface OMDBAPIService {
    @GET("/")
    suspend fun searchMovies(
        @Query("s") searchTerm: String,
        @Query("apikey") apiKey: String = ApiConstants.API_KEY
    ): MovieResponse
}