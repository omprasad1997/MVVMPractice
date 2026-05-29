package com.example.mvvmpractice.mvvm_clean_xml_live_data.domain.usecase

import com.example.mvvmpractice.mvvm_clean_xml_live_data.domain.model.Movie
import com.example.mvvmpractice.mvvm_clean_xml_live_data.domain.repository.MovieRepository

class SearchMoviesUseCase(
    private val repository: MovieRepository
) {

    suspend operator fun invoke(
        query: String
    ): List<Movie> {

        return repository.searchMovies(query)
    }
}