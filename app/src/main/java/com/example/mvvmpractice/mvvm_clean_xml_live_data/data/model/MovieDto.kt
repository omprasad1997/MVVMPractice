package com.example.mvvmpractice.mvvm_clean_xml_live_data.data.model

import com.google.gson.annotations.SerializedName

data class MovieDto(

    @SerializedName("Title")
    val title: String,

    @SerializedName("Year")
    val year: String,

    @SerializedName("Poster")
    val poster: String
)