package com.example.imdbapp.di.providers

import com.example.imdbapp.data.ImdbApiService
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitProvider {

    private val gson: Gson = GsonBuilder().setLenient().create()

    private val gsonConverterFactory: GsonConverterFactory = GsonConverterFactory.create(gson)

    private val retrofit: Retrofit =
        Retrofit.Builder().addConverterFactory(gsonConverterFactory)
            .baseUrl("http://localhost/").build()

    fun provideApiService(): ImdbApiService = retrofit.create(ImdbApiService::class.java)


}