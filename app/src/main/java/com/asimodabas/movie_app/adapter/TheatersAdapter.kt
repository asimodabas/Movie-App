package com.asimodabas.movie_app.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.asimodabas.movie_app.databinding.RowTheatersLayoutBinding
import com.asimodabas.movie_app.model.MovieCategory
import com.asimodabas.movie_app.model.Now
import com.asimodabas.movie_app.ui.fragment.HomeFragmentDirections
import com.asimodabas.movie_app.util.downloadFromUrl
import com.asimodabas.movie_app.util.placeHolderProgressBar

class TheatersAdapter(private val nowList: ArrayList<Now>) :
    RecyclerView.Adapter<TheatersAdapter.MyViewHolder>() {

    class MyViewHolder(val binding: RowTheatersLayoutBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding =
            RowTheatersLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.rowTheatersTitle.text = nowList[position].title
        holder.binding.rowTheatersAverage.text = nowList[position].vote_average.toString()
        holder.binding.rowTheatersDate.text = nowList[position].release_date
        holder.binding.rowTheatersImage.downloadFromUrl(
            nowList[position].poster_path, placeHolderProgressBar(holder.itemView.context)
        )
        holder.binding.linearTheaters.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToDetailFragment(
                nowList[position].id, MovieCategory.Now.ordinal
            )
            Navigation.findNavController(it).navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return nowList.size
    }

    fun updateNowList(updateNowPlaying: List<Now>) {
        nowList.clear()
        nowList.addAll(updateNowPlaying)
        notifyDataSetChanged()
    }
}
