package com.example.imdbapp.data

import com.example.imdbapp.data.sources.api.model.response.PopularGenresResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.HeaderMap
import retrofit2.http.Url

interface ImdbApiService {

    @GET
    suspend fun getPopularGenres(
        @Url url: String,
        @HeaderMap headers: Map<String, String>
    ): Response<PopularGenresResponse>
}