package com.example.imdbapp.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.imdbapp.domain.AppResult
import com.example.imdbapp.domain.entities.PopularGenresEntity
import com.example.imdbapp.domain.usecases.GenreUseCase
import kotlinx.coroutines.launch

class MainActivityViewModel(private val genreUseCase: GenreUseCase): ViewModel() {

    private val _genreListLiveData: MutableLiveData<Event<List<PopularGenresEntity>>> = MutableLiveData()
    val genreListLiveData: LiveData<Event<List<PopularGenresEntity>>> get() = _genreListLiveData

    private val _errorLiveData: MutableLiveData<Event<Boolean>> = MutableLiveData(Event(false))
    val errorLiveData: LiveData<Event<Boolean>> get() = _errorLiveData

    fun getPopularGenreList(){
        viewModelScope.launch {
            when(val result = genreUseCase.getPopularGenres()){
                is AppResult.Success -> _genreListLiveData.value = Event(result.data)
                is AppResult.Failure -> _errorLiveData.value = Event(true)
            }
        }
    }
}