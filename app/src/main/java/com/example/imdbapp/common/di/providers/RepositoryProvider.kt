package com.example.imdbapp.common.di.providers

import com.example.imdbapp.data.repository.GenreRepository
import com.example.imdbapp.data.repository.GenreRepositoryImpl

class RepositoryProvider(
    private val apiSourceProvider: ApiSourceProvider,
    private val internetSourceProvider: InternetSourceProvider
) {

    private val genreRepository by lazy {
        GenreRepositoryImpl(apiSourceProvider.provideGenreSource())
    }

    fun provideGenreRepository(): GenreRepository = genreRepository
}