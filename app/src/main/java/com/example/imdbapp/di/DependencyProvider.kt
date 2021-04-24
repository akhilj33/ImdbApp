package com.example.imdbapp.di

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import com.example.imdbapp.di.providers.*

object DependencyProvider {
    private lateinit var applicationContext: Context

    fun inject(context: Context) {
        applicationContext = context
    }

    private val retrofitProvider: RetrofitProvider by lazy {
        RetrofitProvider()
    }

    private val apiSourceProvider: ApiSourceProvider by lazy {
        ApiSourceProvider()
    }

    private val internetSourceProvider: InternetSourceProvider by lazy {
        InternetSourceProvider(provideApplicationContext())
    }

    /*-------------------------------Repository------------------------------------------*/

    private val repositoryProvider: RepositoryProvider by lazy {
        RepositoryProvider(
            apiSourceProvider,
            internetSourceProvider
        )
    }

    /*-------------------------------Use Case------------------------------------------*/

    private val useCaseProvider: UseCaseProvider by lazy { UseCaseProvider(repositoryProvider) }

    private val viewModelFactory: ViewModelProvider.Factory by lazy {
        ViewModelFactoryProvider(
            useCaseProvider
        )
    }

    /*-------------------------------Public Providers------------------------------------------*/

    private fun provideApplicationContext() = applicationContext

    fun provideViewModelFactory(): ViewModelProvider.Factory = viewModelFactory

    fun provideUseCaseProvider(): UseCaseProvider = useCaseProvider
}