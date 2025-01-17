package com.aldajo92.pizzasapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.aldajo92.pizzasapp.data.MockDataSource
import com.aldajo92.pizzasapp.presentation.main.MainScreen
import com.aldajo92.pizzasapp.presentation.main.MainViewModel
import com.aldajo92.pizzasapp.repository.PizzaRepository

class MainActivity : ComponentActivity() {

    private val mainViewModel = MainViewModel(
        PizzaRepository(MockDataSource())
    ) // Warning!! Should be provided by viewModel provider

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MainScreen(mainViewModel)
        }
    }
}
