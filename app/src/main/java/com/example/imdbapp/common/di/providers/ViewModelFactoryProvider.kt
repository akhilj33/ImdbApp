package com.example.imdbapp.common.di.providers

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.imdbapp.presentation.MainActivityViewModel
import java.lang.IllegalArgumentException

class ViewModelFactoryProvider(private val useCaseProvider: UseCaseProvider) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        when {
            modelClass.isAssignableFrom(MainActivityViewModel::class.java) -> {
                return MainActivityViewModel(useCaseProvider.provideGenreUseCase()) as T
            }

            else -> throw IllegalArgumentException("Unknown ViewModel Class")
        }
    }
}