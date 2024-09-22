package com.task.tourismsmart.api

import com.task.tourismsmart.doman.Activity
import com.task.tourismsmart.doman.Cities
import com.task.tourismsmart.doman.CitiesResponse
import com.task.tourismsmart.doman.Hotel
import com.task.tourismsmart.doman.Restaurant
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {
    @GET("data_hotels.json")
    suspend fun getHotels(): List<Hotel>

    @GET("data_restaurant_cafe.json")
    suspend fun getRestaurant(): List<Restaurant>

    @GET("data_activity.json")
    suspend fun getActivity(): List<Activity>

    @GET("cities.json")
    suspend fun getCities(): CitiesResponse

}
object RetrofitInstance{

    private const val BASE_URL = "https://kareemkm.github.io/Data_Tourism_Smart/"

    val api: ApiService by lazy {
        Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}