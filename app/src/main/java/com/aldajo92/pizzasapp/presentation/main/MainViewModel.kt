package com.aldajo92.pizzasapp.presentation.main

import com.aldajo92.pizzasapp.repository.PizzaRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

// 5. Presentation
class MainViewModel(
    private val repository: PizzaRepository // Warning!! Must use an Interface
) {

    private val _pizzaFlow = MutableStateFlow<List<String>>(listOf())
    val pizzaFlow : StateFlow<List<String>> = _pizzaFlow

    private val _searchFlow = MutableStateFlow("")
    val searchFlow : StateFlow<String> = _searchFlow

    private val _selectedPizza = MutableStateFlow("None")
    val selectedPizza : StateFlow<String> = _selectedPizza

    fun getPizzas(){
        _pizzaFlow.value = repository.getNames()
    }

    fun updateSearch(text: String){
        _searchFlow.value = text.map { it.uppercase() }.joinToString("")
    }

    fun updateSelectedPizza(name: String){
        _selectedPizza.value = name
    }
}
