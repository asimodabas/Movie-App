package com.asimodabas.recyclerview_movie

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class FilmlerAdapter(private val mContext: Context, private val FilmlerListesi: List<Filimler>) :
    RecyclerView.Adapter<FilmlerAdapter.CardTasarimNesneleri>() {
    inner class CardTasarimNesneleri(view: View) : RecyclerView.ViewHolder(view) {

        var imageViewResim: ImageView
        var textViewFilmBaslik: TextView
        var textViewFilmFiyat: TextView
        var buttonSepeteEkle: Button

        init {
            imageViewResim = view.findViewById(R.id.imageViewFilmResim)
            textViewFilmBaslik = view.findViewById(R.id.textViewFilmBaslik)
            textViewFilmFiyat = view.findViewById(R.id.textViewFilmFiyat)
            buttonSepeteEkle = view.findViewById(R.id.buttonSepeteEkle)


        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimNesneleri {
        val tasarim = LayoutInflater.from(mContext).inflate(R.layout.card_film_tasarim, parent, false)
        return CardTasarimNesneleri(tasarim)
    }

    override fun onBindViewHolder(holder: CardTasarimNesneleri, position: Int) {
        val film=FilmlerListesi[position]
        holder.textViewFilmBaslik.text=film.film_ad
        holder.textViewFilmFiyat.text="${film.film_fiyat} TL"
        holder.imageViewResim.setImageResource(
            mContext.resources.getIdentifier(film.film_resim_ad,"drawable",mContext.packageName))
        holder.buttonSepeteEkle.setOnClickListener {
            Toast.makeText(mContext,"${film.film_ad}Sepete Eklendi",Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return FilmlerListesi.size
    }
}