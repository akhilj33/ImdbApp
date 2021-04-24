package com.example.imdbapp.data.sources

import com.example.imdbapp.data.ImdbApiService

interface GenreSource {
    fun getPopularGenre()
}

class ReposGenre(private val apiService: ImdbApiService): GenreSource {
    override fun getPopularGenre() {
        TODO("Not yet implemented")
    }

}