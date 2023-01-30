package com.asimodabas.movie_app.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.asimodabas.movie_app.R
import com.asimodabas.movie_app.databinding.FragmentDetailBinding
import com.asimodabas.movie_app.model.MovieCategory
import com.asimodabas.movie_app.util.viewBinding
import com.asimodabas.movie_app.viewmodel.DetailViewModel
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment(R.layout.fragment_detail) {

    private val binding by viewBinding(FragmentDetailBinding::bind)
    private val viewModel: DetailViewModel by viewModels()
    private val args by navArgs<DetailFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.ivBack.setOnClickListener {
            requireActivity().onBackPressed()
        }

        when (args.movieCategory) {
            MovieCategory.Movie.ordinal -> {
                viewModel.getDetailMovieRoom(args.movieUid)
                observeMovieData()
            }
            MovieCategory.Populer.ordinal -> {
                viewModel.getDetailPopularRoom(args.movieUid)
                observePopularData()
            }
            MovieCategory.Now.ordinal -> {
                viewModel.getDetailTheatersRoom(args.movieUid)
                observeTheatersData()
            }
        }
    }

    private fun observePopularData() {
        viewModel.populars.observe(viewLifecycleOwner, Observer { popular ->
            popular.let {
                binding.tvTitle.text = popular.title
                binding.tvComment.text = popular.overview
                binding.tvAverage.text = popular.vote_average.toString()
                binding.tvVote.text = popular.vote_count.toString()
                binding.tvDate.text = popular.release_date

                Glide.with(requireContext())
                    .load("https://image.tmdb.org/t/p/w500" + popular.backdrop_path)
                    .into(binding.ivDetail)

                Glide.with(requireContext())
                    .load("https://image.tmdb.org/t/p/w500" + popular.poster_path)
                    .into(binding.ivDetailImage)
            }
        })
    }

    private fun observeTheatersData() {
        viewModel.theaters.observe(viewLifecycleOwner, Observer { now ->
            now.let {
                binding.tvTitle.text = now.title
                binding.tvComment.text = now.overview
                binding.tvAverage.text = now.vote_average.toString()
                binding.tvVote.text = now.vote_count.toString()
                binding.tvDate.text = now.release_date

                Glide.with(requireContext())
                    .load("https://image.tmdb.org/t/p/w500" + now.backdrop_path)
                    .into(binding.ivDetail)

                Glide.with(requireContext())
                    .load("https://image.tmdb.org/t/p/w500" + now.poster_path)
                    .into(binding.ivDetailImage)
            }
        })
    }

    private fun observeMovieData() {
        viewModel.movies.observe(viewLifecycleOwner, Observer { movie ->
            movie.let {
                binding.tvTitle.text = movie.title
                binding.tvComment.text = movie.overview
                binding.tvAverage.text = movie.vote_average.toString()
                binding.tvVote.text = movie.vote_count.toString()
                binding.tvDate.text = movie.release_date

                Glide.with(requireContext())
                    .load("https://image.tmdb.org/t/p/w500" + movie.backdrop_path)
                    .into(binding.ivDetail)

                Glide.with(requireContext())
                    .load("https://image.tmdb.org/t/p/w500" + movie.poster_path)
                    .into(binding.ivDetailImage)
            }
        })
    }
}