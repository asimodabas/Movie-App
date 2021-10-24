package com.asimodabas.recyclerview_movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbarblack.title. = "Film Satın Al"
        toolbarblack.subtitle = "Satın almak için bir seçim yapınız"
    }
}