package com.asimodabas.movie_app.service.retrofit

import com.asimodabas.movie_app.model.MovieResponse
import com.asimodabas.movie_app.model.NowResult
import com.asimodabas.movie_app.model.PopularResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("3/movie/top_rated")
    fun getMovies(
        @Query("api_key") apikey: String,
        @Query("page") page: Int,
        @Query("language") language: String
    ): Single<MovieResponse>

    @GET("3/movie/popular")
    fun getPopular(
        @Query("api_key") apikey: String,
        @Query("language") language: String
    ): Single<PopularResponse>

    @GET("3/movie/now_playing")
    fun getNowPlaying(
        @Query("api_key") apikey: String,
        @Query("language") language: String
    ): Single<NowResult>
}