package com.aldajo92.pizzasapp.framework

import com.aldajo92.pizzasapp.framework.model.PizzaDTO
import retrofit2.http.GET

interface PizzaAPI {

    @GET("pizza")
    suspend fun getPizzas(): List<PizzaDTO>

}
