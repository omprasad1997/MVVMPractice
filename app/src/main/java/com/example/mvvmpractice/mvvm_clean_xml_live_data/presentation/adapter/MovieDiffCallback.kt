package com.example.mvvmpractice.mvvm_clean_xml_live_data.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.mvvmpractice.mvvm_clean_xml_live_data.domain.model.Movie

class MovieDiffCallback : DiffUtil.ItemCallback<Movie>() {

    override fun areItemsTheSame(
        oldItem: Movie,
        newItem: Movie
    ): Boolean {

        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(
        oldItem: Movie,
        newItem: Movie
    ): Boolean {

        return oldItem == newItem
    }
}