package com.example.imdbapp.common.utils

object ApiUrlBuilder {

    private const val BASE_URL = "https://imdb8.p.rapidapi.com/"
    private const val TITLE = "title/"
    private const val POPULAR_GENRE = "list-popular-genres"

    fun getPopularGenresUrl() = BASE_URL + TITLE + POPULAR_GENRE
}