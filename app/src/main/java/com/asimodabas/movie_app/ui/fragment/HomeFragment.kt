package com.asimodabas.movie_app.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.asimodabas.movie_app.R
import com.asimodabas.movie_app.adapter.MovieAdapter
import com.asimodabas.movie_app.adapter.PopularAdapter
import com.asimodabas.movie_app.adapter.TheatersAdapter
import com.asimodabas.movie_app.databinding.FragmentHomeBinding
import com.asimodabas.movie_app.util.viewBinding
import com.asimodabas.movie_app.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {

    private val binding by viewBinding(FragmentHomeBinding::bind)
    private val viewModel: HomeViewModel by viewModels()
    private lateinit var movieAdapter: MovieAdapter
    private lateinit var popularAdapter: PopularAdapter
    private lateinit var theatersAdapter: TheatersAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getLiveData()
        viewModel.getPopularLiveData()
        viewModel.getNowPlayingLiveData()

        swipeRefresh()
        getRecycler()
        observeLiveData()

        binding.ivSearch.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToSearchFragment()
            Navigation.findNavController(it).navigate(action)
        }
    }

    private fun swipeRefresh() {
        binding.swipeRefreshLayout.setOnRefreshListener {
            viewModel.refreshData()
            binding.swipeRefreshLayout.isRefreshing = false
        }
    }

    private fun observeLiveData() {
        viewModel.moviedata.observe(viewLifecycleOwner, Observer { movies ->
            movies.let {
                movieAdapter.updateMovieListe(movies)
            }
        })

        viewModel.popularData.observe(viewLifecycleOwner, Observer { popular ->
            popular.let {
                popularAdapter.updatePopularList(popular)
            }
        })

        viewModel.nowPlayingData.observe(viewLifecycleOwner, Observer { now ->
            now.let {
                theatersAdapter.updateNowList(now)
            }
        })
    }

    private fun getRecycler() {
        binding.rvHighly.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        movieAdapter = MovieAdapter(arrayListOf())
        binding.rvHighly.adapter = movieAdapter
        binding.rvHighly.set3DItem(true)
        binding.rvHighly.setAlpha(true)
        binding.rvHighly.setInfinite(true)

        binding.rvPopular.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        popularAdapter = PopularAdapter(arrayListOf())
        binding.rvPopular.adapter = popularAdapter
        binding.rvPopular.set3DItem(true)
        binding.rvPopular.setAlpha(true)
        binding.rvPopular.setInfinite(true)

        binding.rvTheaters.layoutManager = LinearLayoutManager(context)
        theatersAdapter = TheatersAdapter(arrayListOf())
        binding.rvTheaters.adapter = theatersAdapter
    }
}