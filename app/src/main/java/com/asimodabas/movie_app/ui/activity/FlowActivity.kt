package com.asimodabas.movie_app.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.asimodabas.movie_app.R
import com.asimodabas.movie_app.databinding.ActivityFlowBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FlowActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFlowBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFlowBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fContainerMain)
        navController = (navHostFragment as NavHostFragment).navController
    }
}