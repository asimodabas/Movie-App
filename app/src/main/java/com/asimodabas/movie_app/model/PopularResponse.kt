package com.asimodabas.movie_app.model

data class PopularResponse(
    val page: Int,
    val results: List<Popular>,
    val total_pages: Int,
    val total_results: Int
)