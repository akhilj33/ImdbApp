package com.example.imdbapp.domain.usecases

import com.example.imdbapp.data.repository.GenreRepository
import com.example.imdbapp.domain.AppResult
import com.example.imdbapp.domain.entities.PopularGenresEntity

interface GenreUseCase {
    suspend fun getPopularGenres(): AppResult<List<PopularGenresEntity>>
}

class GenreUseCaseImpl(private val genreRepository: GenreRepository) : GenreUseCase {
    override suspend fun getPopularGenres(): AppResult<List<PopularGenresEntity>> {
        return genreRepository.getPopularGenres()
    }

}