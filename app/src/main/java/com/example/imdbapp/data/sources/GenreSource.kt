package com.example.imdbapp.data.sources

import com.example.imdbapp.common.utils.ApiUrlBuilder
import com.example.imdbapp.common.utils.DefaultHeaderBuilder
import com.example.imdbapp.common.utils.ErrorCodes
import com.example.imdbapp.data.ErrorMapper
import com.example.imdbapp.data.ImdbApiService
import com.example.imdbapp.data.sources.api.model.response.PopularGenresResponse
import com.example.imdbapp.domain.AppError
import com.example.imdbapp.domain.AppResult
import com.example.imdbapp.domain.RetrofitResult
import com.example.imdbapp.domain.entities.PopularGenresEntity
import retrofit2.Response

interface GenreSource {
    suspend fun getPopularGenres(): AppResult<List<PopularGenresEntity>>
}

class GenreSourceImpl(private val apiService: ImdbApiService) : GenreSource {
    override suspend fun getPopularGenres(): AppResult<List<PopularGenresEntity>> {
        var response: Response<PopularGenresResponse>? = null
        var exception: Exception? = null

        try {
            response = apiService.getPopularGenres(ApiUrlBuilder.getPopularGenresUrl(), DefaultHeaderBuilder.getDefaultHeaders())
        } catch (e: Exception) {
            exception = e
        }

        return when (val result =
            ErrorMapper.checkAndMapError(response, exception)) {
            is RetrofitResult.Success -> {
                if (result.data != null) {
                    AppResult.Success(popularGenresEntityMapper(result.data))
                } else {
                    AppResult.Failure(AppError(ErrorCodes.GENERIC_ERROR))
                }
            }

            is RetrofitResult.Failure -> AppResult.Failure(result.error)
        }

    }

}

/*---------------------------------------Entity Mappers-------------------------------------------*/

private fun popularGenresEntityMapper(popularGenresResponse: PopularGenresResponse): List<PopularGenresEntity> {
    return popularGenresResponse.popularGenreList?.map {
        PopularGenresEntity(it.name, it.endpoint)
    } ?: listOf()
}