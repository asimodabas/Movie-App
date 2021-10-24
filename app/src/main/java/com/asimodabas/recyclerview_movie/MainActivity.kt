package com.asimodabas.recyclerview_movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var filmlerArrayList:ArrayList<Filimler>
    private lateinit var adapter:FilmlerAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        rv.setHasFixedSize(true)
        rv.layoutManager=StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
        val f1=Filimler(1,"La Casa De Papel","lacasadepapel",11.99)
        val f2=Filimler(2,"Prison Break","prisonbreak",29.99)
        val f3=Filimler(3,"Ezel","ezel",24.99)
        val f4=Filimler(4,"Breaking Bad","breakingbad",20.99)
        val f5=Filimler(5,"Lupin","lupin",15.99)
        val f6=Filimler(6,"Matrix","matrix",21.99)



        filmlerArrayList=ArrayList<Filimler>()
        filmlerArrayList.add(f1)
        filmlerArrayList.add(f2)
        filmlerArrayList.add(f3)
        filmlerArrayList.add(f4)
        filmlerArrayList.add(f5)
        filmlerArrayList.add(f6)

        adapter=FilmlerAdapter(this,filmlerArrayList)
        rv.adapter=adapter

        toolbarblack.title = "Film Satın Al"
        toolbarblack.subtitle = "Satın almak için bir seçim yapınız"
    }
}