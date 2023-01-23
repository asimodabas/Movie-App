package com.asimodabas.movie_app.viewmodel

import android.app.Application
import com.asimodabas.movie_app.service.database.DaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    application: Application, private val dbRepository: DaoRepository
) : BaseViewModel(application) {
}