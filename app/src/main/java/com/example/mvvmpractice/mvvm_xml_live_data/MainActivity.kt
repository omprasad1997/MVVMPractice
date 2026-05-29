package com.example.mvvmpractice.mvvm_xml_live_data

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmpractice.R
import com.example.mvvmpractice.mvvm_xml_live_data.di.DaggerAppComponent
import com.example.mvvmpractice.mvvm_xml_live_data.repository.MovieRepository
import com.example.mvvmpractice.mvvm_xml_live_data.ui.adapter.MovieAdapter
import com.example.mvvmpractice.mvvm_xml_live_data.ui.viewmodel.MovieViewModel
import com.example.mvvmpractice.mvvm_xml_live_data.ui.viewmodel.MovieViewModelFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var movieRepository: MovieRepository

    private lateinit var movieViewModel : MovieViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        DaggerAppComponent.create().inject(this)

        movieViewModel = ViewModelProvider(this, MovieViewModelFactory(movieRepository))[MovieViewModel::class.java]

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        movieViewModel.movies.observe(this){
            recyclerView.adapter = MovieAdapter(it)
        }

        findViewById<Button>(R.id.btnSearch)
            .setOnClickListener {

                val query =
                    findViewById<EditText>(R.id.etSearch)
                        .text.toString()

                movieViewModel.searchMovies(query)
            }
    }
}