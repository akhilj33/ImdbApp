package com.example.imdbapp.common.di.providers

import com.example.imdbapp.domain.usecases.GenreUseCase
import com.example.imdbapp.domain.usecases.GenreUseCaseImpl

class UseCaseProvider(private val repositoryProvider: RepositoryProvider) {

    fun provideGenreUseCase(): GenreUseCase = GenreUseCaseImpl(repositoryProvider.provideGenreRepository())
}