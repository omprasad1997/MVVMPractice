package com.example.mvvmpractice.mvvm_clean_xml_live_data.data.remote

import com.example.mvvmpractice.mvvm_clean_xml_live_data.data.model.MovieResponseDto
import com.example.mvvmpractice.mvvm_xml_live_data.utils.ApiConstants
import retrofit2.http.GET
import retrofit2.http.Query

interface OMDBAPIService {
    @GET("/")
    suspend fun searchMovies(
        @Query("s") searchTerm: String,
        @Query("apikey") apiKey: String = ApiConstants.API_KEY
    ): MovieResponseDto
}