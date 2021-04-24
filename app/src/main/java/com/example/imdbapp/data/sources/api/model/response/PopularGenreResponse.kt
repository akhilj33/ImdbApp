package com.example.imdbapp.data.sources.api.model.response

import com.google.gson.annotations.SerializedName

data class PopularGenresResponse(
    @SerializedName("genres")
    val popularGenreList: List<GenreListItem>? = null
)

data class GenreListItem(
    @SerializedName("description")
    val name: String? = null,
    @SerializedName("endpoint")
    val endpoint: String? = null
)
