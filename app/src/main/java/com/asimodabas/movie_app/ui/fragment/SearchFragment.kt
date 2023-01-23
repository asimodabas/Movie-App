package com.asimodabas.movie_app.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.asimodabas.movie_app.R
import com.asimodabas.movie_app.databinding.FragmentSearchBinding
import com.asimodabas.movie_app.util.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment : Fragment(R.layout.fragment_search) {

    private val binding by viewBinding(FragmentSearchBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}