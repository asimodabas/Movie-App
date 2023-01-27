package com.asimodabas.movie_app.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.asimodabas.movie_app.databinding.RowMainLayoutBinding
import com.asimodabas.movie_app.model.MovieCategory
import com.asimodabas.movie_app.model.Popular
import com.asimodabas.movie_app.ui.fragment.HomeFragmentDirections
import com.asimodabas.movie_app.util.downloadFromUrl
import com.asimodabas.movie_app.util.placeHolderProgressBar

class PopularAdapter(private val popularList: ArrayList<Popular>) :
    RecyclerView.Adapter<PopularAdapter.MyViewHolder>() {

    class MyViewHolder(val binding: RowMainLayoutBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding =
            RowMainLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.rowTitle.text = popularList[position].title
        holder.binding.rowAverage.text = popularList[position].vote_average.toString()

        holder.binding.ivMovieImage.downloadFromUrl(
            popularList[position].poster_path, placeHolderProgressBar(holder.itemView.context)
        )

        holder.binding.movieLayout.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToDetailFragment(
                popularList[position].id, MovieCategory.Populer.ordinal
            )
            Navigation.findNavController(it).navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return popularList.size
    }

    fun updatePopularList(updatePopular: List<Popular>) {
        popularList.clear()
        popularList.addAll(updatePopular)
        notifyDataSetChanged()
    }
}
