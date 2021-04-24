package com.example.imdbapp.di.providers

import com.example.imdbapp.di.providers.ApiSourceProvider
import com.example.imdbapp.di.providers.InternetSourceProvider

class RepositoryProvider(
    apiSourceProvider: ApiSourceProvider,
    internetSourceProvider: InternetSourceProvider
) {
}