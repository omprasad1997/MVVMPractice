package com.example.mvvmpractice.mvvm_clean_xml_live_data.domain.repository

import com.example.mvvmpractice.mvvm_clean_xml_live_data.domain.model.Movie

interface MovieRepository {
    suspend fun searchMovies(
        query: String
    ): List<Movie>
}