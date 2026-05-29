package com.example.mvvmpractice.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmpractice.repository.MovieRepository
import com.example.mvvmpractice.model.Movie
import com.example.mvvmpractice.utils.ApiConstants
import kotlinx.coroutines.launch
import javax.inject.Inject

class MovieViewModel @Inject constructor(
    private val movieRepository: MovieRepository
) : ViewModel()
 {
        private var _movies = MutableLiveData<List<Movie>>()
        val movies get() = _movies

     fun searchMovies(searchTerm: String) {
         viewModelScope.launch {
             try {
                 Log.d(ApiConstants.TAG, "viewmodel called")
                 val response = movieRepository.searchMovies(searchTerm)
                 _movies.value = response.Search
             } catch (e : Exception){
                 e.printStackTrace()
                 Log.d(ApiConstants.TAG, "viewmodel error ${e.message}")
             }
         }
     }
}