package com.aldajo92.pizzasapp.repository

import com.aldajo92.pizzasapp.data.PizzaDataSource

// 4. Repository
class PizzaRepository(
    private val pizzaDS: PizzaDataSource
) {
    fun getNames(): List<String> {
        return pizzaDS.getList().map { it.name }
    }

    fun removePizza(name: String) {
        val pizzaList = pizzaDS.getList()
        val idToRemove = pizzaList.indexOfFirst { it.name == name }

        if (idToRemove != -1) {
            pizzaDS.removeItem(idToRemove)
        } else {
            throw IllegalArgumentException("Pizza with name '$name' not found.")
        }
    }
}