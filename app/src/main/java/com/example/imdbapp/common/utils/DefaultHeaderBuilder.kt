package com.example.imdbapp.common.utils

object DefaultHeaderBuilder {
    fun getDefaultHeaders(): MutableMap<String, String> {
        val map: MutableMap<String, String> = mutableMapOf()
        map["X-RapidAPI-Key"] = "9d26df973amsh0bcb2252e377934p138b2cjsn5cc82f12ef50"
        map["X-RapidAPI-Host"] = "imdb8.p.rapidapi.com"
        return map
    }
}