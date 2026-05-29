package com.example.mvvmpractice.mvvm_clean_xml_live_data.data.model

import com.google.gson.annotations.SerializedName

data class MovieResponseDto(
    @SerializedName("Search")
    val search: List<MovieDto>
)