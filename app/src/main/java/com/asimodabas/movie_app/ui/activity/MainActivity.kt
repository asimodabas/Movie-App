package com.asimodabas.movie_app.ui.activity

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import androidx.appcompat.app.AppCompatActivity
import com.asimodabas.movie_app.R
import com.asimodabas.movie_app.util.Constants.COUNTDOWN_INTERVAL
import com.asimodabas.movie_app.util.Constants.MILLSIN_FUTURE
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        val timer = object : CountDownTimer(MILLSIN_FUTURE, COUNTDOWN_INTERVAL) {
            override fun onTick(millisUntilFinished: Long) {}
            override fun onFinish() {
                startActivity(Intent(this@MainActivity, FlowActivity::class.java))
                finish()
            }
        }
        timer.start()
    }
}