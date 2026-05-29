package com.example.mvvmpractice.mvvm_clean_xml_live_data.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmpractice.mvvm_clean_xml_live_data.domain.model.Movie
import com.example.mvvmpractice.mvvm_clean_xml_live_data.domain.usecase.SearchMoviesUseCase
import com.example.mvvmpractice.mvvm_xml_live_data.utils.ApiConstants
import kotlinx.coroutines.launch

class MovieViewModel(
    private val searchMoviesUseCase:
    SearchMoviesUseCase
) : ViewModel() {
    private var _movies = MutableLiveData<List<Movie>>()
    val movies get() = _movies

    fun searchMovies(query: String) {
        viewModelScope.launch {
            try {
                Log.d(ApiConstants.TAG, "viewmodel2 called")
                val response = searchMoviesUseCase(query)
                _movies.value = response
            } catch (e : Exception){
                e.printStackTrace()
                Log.d(ApiConstants.TAG, "viewmodel2 error ${e.message}")
            }
        }
    }
}