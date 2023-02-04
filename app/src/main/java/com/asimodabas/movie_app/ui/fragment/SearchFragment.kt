package com.asimodabas.movie_app.ui.fragment

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.asimodabas.movie_app.R
import com.asimodabas.movie_app.adapter.SearchAdapter
import com.asimodabas.movie_app.databinding.FragmentSearchBinding
import com.asimodabas.movie_app.util.viewBinding
import com.asimodabas.movie_app.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment : Fragment(R.layout.fragment_search) {

    private val binding by viewBinding(FragmentSearchBinding::bind)
    private val homeViewModel: HomeViewModel by viewModels()
    private lateinit var searchAdapter: SearchAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeLiveData()
        homeViewModel.getLiveData()
        binding.rvSearch.layoutManager = LinearLayoutManager(context)
        searchAdapter = SearchAdapter(arrayListOf())
        binding.rvSearch.adapter = searchAdapter
        binding.rvSearch.visibility = View.GONE
        binding.ivBack.setOnClickListener {
            requireActivity().onBackPressed()
        }

        binding.etSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (p0 != null) {
                    searchDatabase(p0.toString())
                    binding.rvSearch.visibility = View.VISIBLE
                }
            }

            override fun afterTextChanged(p0: Editable?) {
            }
        })
    }

    private fun searchDatabase(deger: CharSequence) {
        val searchQuery = "%$deger%"
        homeViewModel.searchDatabase(searchQuery).observe(viewLifecycleOwner) { search ->
            search.let {
                searchAdapter.updateMovieListe(search)
            }
        }
    }

    private fun observeLiveData() {
        homeViewModel.moviedata.observe(viewLifecycleOwner) { movie ->
            movie.let {
                searchAdapter.updateMovieListe(movie)
            }
        }
    }
}