package com.example.mvvmpractice.mvvm_clean_xml_live_data.data.mapper

import com.example.mvvmpractice.mvvm_clean_xml_live_data.data.model.MovieDto
import com.example.mvvmpractice.mvvm_clean_xml_live_data.domain.model.Movie

fun MovieDto.toDomain(): Movie {

    return Movie(
        title = title,
        year = year,
        poster = poster
    )
}