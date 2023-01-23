package com.asimodabas.movie_app.service.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.asimodabas.movie_app.model.Movie
import com.asimodabas.movie_app.model.Now
import com.asimodabas.movie_app.model.Popular

@Dao
interface MovieDeo {

    @Query("SELECT * FROM movie")
    suspend fun getAllMovie(): List<Movie>

    @Query("SELECT * FROM movie WHERE id=:id")
    suspend fun getMovieId(id: Int): Movie

    @Insert
    suspend fun insertAll(movies: Array<Movie>): List<Long>

    @Query("DELETE FROM movie")
    suspend fun deleteMovies()

    @Query("SELECT * FROM movie WHERE title LIKE :search")
    fun searchDatabaseMovie(search: String): kotlinx.coroutines.flow.Flow<List<Movie>>

    @Query("SELECT * FROM popular")
    suspend fun getAllPopular(): List<Popular>

    @Query("SELECT * FROM popular WHERE id=:id")
    suspend fun getPopularId(id: Int): Popular

    @Insert
    suspend fun insertAllPopular(popular: Array<Popular>): List<Long>

    @Query("DELETE FROM popular")
    suspend fun deletePopulars()

    @Query("SELECT * FROM now")
    suspend fun getAllNow(): List<Now>

    @Query("SELECT * FROM now WHERE id=:id")
    suspend fun getNowId(id: Int): Now

    @Insert
    suspend fun insertAllNow(now: Array<Now>): List<Long>

    @Query("DELETE FROM now")
    suspend fun deleteNows()
}