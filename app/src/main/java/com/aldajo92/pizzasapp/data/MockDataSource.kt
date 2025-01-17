package com.aldajo92.pizzasapp.data

class MockDataSource : PizzaDataSource {

    private val pizzaList = (1..10).map{
        PizzaModel(it, "pizza ${it}", 10.0)
    }

    override fun getList() : List<PizzaModel>{
        return pizzaList
    }

    override fun updateList() {

    }

    override fun removeItem(id: Int){

    }
}