package com.asimodabas.movie_app.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.asimodabas.movie_app.databinding.RowSearchLayoutBinding
import com.asimodabas.movie_app.model.Movie
import com.asimodabas.movie_app.model.MovieCategory
import com.asimodabas.movie_app.ui.fragment.SearchFragmentDirections
import com.asimodabas.movie_app.util.downloadFromUrl
import com.asimodabas.movie_app.util.placeHolderProgressBar

class SearchAdapter(private val list: ArrayList<Movie>) :
    RecyclerView.Adapter<SearchAdapter.MyViewHolder>() {

    class MyViewHolder(val binding: RowSearchLayoutBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding =
            RowSearchLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.rowSearchTitle.text = list[position].title
        holder.binding.rowSearchDate.text = list[position].release_date
        holder.binding.rowSearchImage.downloadFromUrl(
            list[position].poster_path, placeHolderProgressBar(holder.itemView.context)
        )
        holder.binding.rowSearchBanner.downloadFromUrl(
            list[position].backdrop_path, placeHolderProgressBar(holder.itemView.context)
        )
        holder.binding.constraintSearch.setOnClickListener {
            val action = SearchFragmentDirections.actionSearchFragmentToDetailFragment(
                list[position].id, MovieCategory.Movie.ordinal
            )
            Navigation.findNavController(it).navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun updateMovieListe(newMovieList: List<Movie>) {
        list.clear()
        list.addAll(newMovieList)
        notifyDataSetChanged()
    }
}