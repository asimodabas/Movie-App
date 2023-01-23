package com.asimodabas.movie_app.service.retrofit

import com.asimodabas.movie_app.model.MovieResponse
import com.asimodabas.movie_app.model.NowResult
import com.asimodabas.movie_app.model.PopularResponse
import com.asimodabas.movie_app.util.Constants.API_KEY
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class ApiServiceRepository @Inject constructor(private val apiService: ApiService) {

    fun getDataService(): Single<MovieResponse> {
        return apiService.getMovies(API_KEY, 5, "tr")
    }

    fun getPopularService(): Single<PopularResponse> {
        return apiService.getPopular(API_KEY, "tr")
    }

    fun getNowPlayingService(): Single<NowResult> {
        return apiService.getNowPlaying(API_KEY, "tr")
    }
}