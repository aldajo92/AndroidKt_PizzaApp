package com.aldajo92.pizzasapp.presentation.main

import com.aldajo92.pizzasapp.repository.PizzaRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

// 5. Presentation
class MainViewModel(
    private val repository: PizzaRepository // Warning!! Must use an Interface
) {

    private val job = Job()
    private val coroutineScope = CoroutineScope(Dispatchers.IO + job)

    private val _pizzaFlow = MutableStateFlow<List<String>>(listOf())
    val pizzaFlow : StateFlow<List<String>> = _pizzaFlow

    private val _searchFlow = MutableStateFlow("")
    val searchFlow : StateFlow<String> = _searchFlow

    private val _selectedPizza = MutableStateFlow("None")
    val selectedPizza : StateFlow<String> = _selectedPizza

    fun getPizzas(){
        coroutineScope.launch {
            try {
                _pizzaFlow.value = repository.getNames()
            } catch (e: Exception) {
                e.printStackTrace() // Handle exceptions
            }
        }
    }

    fun updateSearch(text: String){
        _searchFlow.value = text.map { it.uppercase() }.joinToString("")
    }

    fun updateSelectedPizza(name: String){
        _selectedPizza.value = name
    }
}
