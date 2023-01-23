package com.asimodabas.movie_app.service.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.asimodabas.movie_app.model.Movie
import com.asimodabas.movie_app.model.Now
import com.asimodabas.movie_app.model.Popular

@Database(
    entities = [Movie::class, Popular::class, Now::class], version = 4
)
abstract class MovieDatabase : RoomDatabase() {

    abstract fun movieDao(): MovieDeo
}