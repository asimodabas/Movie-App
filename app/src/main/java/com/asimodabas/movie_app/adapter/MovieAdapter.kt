package com.asimodabas.movie_app.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.asimodabas.movie_app.databinding.RowMainLayoutBinding
import com.asimodabas.movie_app.model.Movie
import com.asimodabas.movie_app.model.MovieCategory
import com.asimodabas.movie_app.ui.fragment.HomeFragmentDirections
import com.asimodabas.movie_app.util.downloadFromUrl
import com.asimodabas.movie_app.util.placeHolderProgressBar

class MovieAdapter(private val movieList: ArrayList<Movie>) :
    RecyclerView.Adapter<MovieAdapter.MyViewHolder>() {

    class MyViewHolder(val binding: RowMainLayoutBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding =
            RowMainLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.rowTitle.text = movieList[position].title
        holder.binding.rowAverage.text = movieList[position].vote_average.toString()
        holder.binding.ivMovieImage.downloadFromUrl(
            movieList[position].poster_path, placeHolderProgressBar(holder.itemView.context)
        )
        holder.binding.movieLayout.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToDetailFragment(
                movieList[position].id, MovieCategory.Movie.ordinal
            )
            Navigation.findNavController(it).navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    fun updateMovieListe(newMovieList: List<Movie>) {
        movieList.clear()
        movieList.addAll(newMovieList)
        notifyDataSetChanged()
    }
}