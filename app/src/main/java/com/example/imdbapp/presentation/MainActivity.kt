package com.example.imdbapp.presentation

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.imdbapp.R
import com.example.imdbapp.common.di.DependencyProvider
import com.example.imdbapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val viewModel: MainActivityViewModel by viewModels { DependencyProvider.provideViewModelFactory() }
    private val genresAdapter by lazy { GenresAdapter() }
    private lateinit var viewBinding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        initRecyclerView()
        setUpObservers()
        viewModel.getPopularGenreList()
    }

    private fun setUpObservers() {
        viewModel.genreListLiveData.observe(this, OneTimeObserver{
            if (!it.isNullOrEmpty())
                genresAdapter.addItems(it)
            else
                showError()
        })

        viewModel.errorLiveData.observe(this, OneTimeObserver{
            if (it) showError()
        })
    }

    private fun showError() {
        Toast.makeText(this, "Something went wrong", Toast.LENGTH_LONG).show()
    }

    private fun initRecyclerView() {
        val gridLayoutManager = StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)

        viewBinding.rvPopularGenres.apply {
            layoutManager = gridLayoutManager
            adapter = genresAdapter
        }
    }
}