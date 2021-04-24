package com.example.imdbapp.common.di.providers

import com.example.imdbapp.data.sources.GenreSource
import com.example.imdbapp.data.sources.GenreSourceImpl

class ApiSourceProvider(private val retrofitProvider: RetrofitProvider) {
    fun provideGenreSource(): GenreSource = GenreSourceImpl(retrofitProvider.provideApiService())
}