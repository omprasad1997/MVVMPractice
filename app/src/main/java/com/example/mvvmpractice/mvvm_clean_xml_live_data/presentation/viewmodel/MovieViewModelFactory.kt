package com.example.mvvmpractice.mvvm_clean_xml_live_data.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmpractice.mvvm_clean_xml_live_data.domain.usecase.SearchMoviesUseCase
import javax.inject.Inject

class MovieViewModelFactory @Inject constructor(
    private val searchMoviesUseCase: SearchMoviesUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(
        modelClass: Class<T>
    ): T {

        if (modelClass.isAssignableFrom(MovieViewModel::class.java)) {

            return MovieViewModel(
                searchMoviesUseCase
            ) as T
        }

        throw IllegalArgumentException(
            "Unknown ViewModel class"
        )
    }
}