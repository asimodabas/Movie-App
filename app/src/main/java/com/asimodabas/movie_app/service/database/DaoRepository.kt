package com.asimodabas.movie_app.service.database

import com.asimodabas.movie_app.model.Movie
import com.asimodabas.movie_app.model.Now
import com.asimodabas.movie_app.model.Popular
import javax.inject.Inject

class DaoRepository @Inject constructor(private val dao: MovieDeo) {

    fun searchDatabaseMovie(search: String) = dao.searchDatabaseMovie(search)
    suspend fun getALLMovie() = dao.getAllMovie()
    suspend fun getMovieId(id: Int) = dao.getMovieId(id)
    suspend fun insertAll(movies: Array<Movie>) = dao.insertAll(movies)
    suspend fun deleteMovies() = dao.deleteMovies()

    suspend fun getAllPopular() = dao.getAllPopular()
    suspend fun getPopularId(id: Int) = dao.getPopularId(id)
    suspend fun insertAllPopular(popular: Array<Popular>) = dao.insertAllPopular(popular)
    suspend fun deletePopulars() = dao.deletePopulars()

    suspend fun getAllTheaters() = dao.getAllTheaters()
    suspend fun getTheatersId(id: Int) = dao.getTheatersId(id)
    suspend fun insertAllTheaters(now: Array<Now>) = dao.insertAllTheaters(now)
    suspend fun deleteTheaters() = dao.deleteTheaters()
}