package com.example.imdbapp.data.repository

import com.example.imdbapp.data.sources.GenreSource
import com.example.imdbapp.domain.AppResult
import com.example.imdbapp.domain.entities.PopularGenresEntity
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

interface GenreRepository {
    suspend fun getPopularGenres(): AppResult<List<PopularGenresEntity>>
}

class GenreRepositoryImpl(
    private val genreSource: GenreSource,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
): GenreRepository {

    override suspend fun getPopularGenres(): AppResult<List<PopularGenresEntity>> {
        return withContext(dispatcher){
                genreSource.getPopularGenres()
        }
    }

}