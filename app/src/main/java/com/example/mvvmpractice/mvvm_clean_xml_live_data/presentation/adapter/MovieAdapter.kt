package com.example.mvvmpractice.mvvm_clean_xml_live_data.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mvvmpractice.databinding.ItemMovieBinding
import com.example.mvvmpractice.mvvm_clean_xml_live_data.domain.model.Movie

class MovieAdapter :
    ListAdapter<Movie, MovieAdapter.MovieViewHolder>(
        MovieDiffCallback()
    ) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MovieViewHolder {

        val binding =
            ItemMovieBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )

        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: MovieViewHolder,
        position: Int
    ) {

        holder.bind(getItem(position))
    }

    inner class MovieViewHolder(
        private val binding: ItemMovieBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(movie: Movie) {

            binding.tvTitle.text =
                movie.title

//            binding.tvYear.text =
//                movie.year

            Glide.with(binding.root.context)
                .load(movie.poster)
                .into(binding.ivPoster)
        }
    }
}