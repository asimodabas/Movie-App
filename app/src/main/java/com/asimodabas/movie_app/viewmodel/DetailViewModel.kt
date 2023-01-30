package com.asimodabas.movie_app.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.asimodabas.movie_app.model.Movie
import com.asimodabas.movie_app.model.Now
import com.asimodabas.movie_app.model.Popular
import com.asimodabas.movie_app.service.database.DaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    application: Application, private val dbRepository: DaoRepository
) : BaseViewModel(application) {

    val movies = MutableLiveData<Movie>()
    val populars = MutableLiveData<Popular>()
    val theaters = MutableLiveData<Now>()

    fun getDetailMovieRoom(id: Int) {
        launch {

            val movieDao = dbRepository.getMovieId(id)
            movies.value = movieDao
        }
    }

    fun getDetailPopularRoom(id: Int) {
        launch {

            val popularDao = dbRepository.getPopularId(id)
            populars.value = popularDao
        }
    }

    fun getDetailTheatersRoom(id: Int) {
        launch {
            val theatersDao = dbRepository.getTheatersId(id)
            theaters.value = theatersDao
        }
    }
}