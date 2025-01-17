package com.aldajo92.pizzasapp.data

// 2. Use Cases
interface PizzaDataSource {
    fun getList() : List<PizzaModel>

    fun updateList()

    fun removeItem(id: Int)
}