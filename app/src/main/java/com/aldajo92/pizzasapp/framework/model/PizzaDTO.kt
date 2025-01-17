package com.aldajo92.pizzasapp.framework.model

import com.squareup.moshi.Json

data class PizzaDTO(
    @Json(name = "id") val id: String,
    @Json(name = "name") val name: String,
    @Json(name = "price") val price: Double,
    @Json(name = "toppings") val toppings: List<String>? = null
)
