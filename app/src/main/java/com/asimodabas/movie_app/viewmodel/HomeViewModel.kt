package com.asimodabas.movie_app.viewmodel

import android.app.Application
import com.asimodabas.movie_app.service.database.DaoRepository
import com.asimodabas.movie_app.service.retrofit.ApiServiceRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val apiRepository: ApiServiceRepository,
    private val dbRepository: DaoRepository,
    application: Application
) : BaseViewModel(application) {

}