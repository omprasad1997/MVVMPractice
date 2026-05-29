package com.example.mvvmpractice.mvvm_clean_xml_live_data.presentation.ui

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmpractice.R
import com.example.mvvmpractice.mvvm_clean_xml_live_data.di.DaggerAppComponent2
import com.example.mvvmpractice.mvvm_clean_xml_live_data.presentation.adapter.MovieAdapter
import com.example.mvvmpractice.mvvm_clean_xml_live_data.presentation.viewmodel.MovieViewModel
import com.example.mvvmpractice.mvvm_clean_xml_live_data.presentation.viewmodel.MovieViewModelFactory
import javax.inject.Inject

class MainActivity2 : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: MovieViewModelFactory

    private lateinit var viewModel: MovieViewModel

    private lateinit var adapter: MovieAdapter

    private lateinit var etSearch: EditText
    private lateinit var btnSearch: Button
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)

        // Dagger Injection
        DaggerAppComponent2.create().inject(this)

        initViews()

        setupRecyclerView()

        setupViewModel()

        observeMovies()

        setupClickListeners()
    }

    private fun initViews() {

        etSearch = findViewById(R.id.etSearch)

        btnSearch = findViewById(R.id.btnSearch)

        recyclerView = findViewById(R.id.recyclerView)
    }

    private fun setupRecyclerView() {

        adapter = MovieAdapter()

        recyclerView.layoutManager =
            LinearLayoutManager(this)

        recyclerView.adapter = adapter
    }

    private fun setupViewModel() {

        viewModel = ViewModelProvider(
            this,
            viewModelFactory
        )[MovieViewModel::class.java]
    }

    private fun observeMovies() {

        viewModel.movies.observe(this) { movies ->

            adapter.submitList(movies)
        }
    }

    private fun setupClickListeners() {

        btnSearch.setOnClickListener {

            val query =
                etSearch.text.toString().trim()

            if (query.isNotEmpty()) {

                viewModel.searchMovies(query)
            }
        }
    }

}