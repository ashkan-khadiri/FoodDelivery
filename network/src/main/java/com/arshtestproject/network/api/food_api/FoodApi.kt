package com.arshtestproject.network.api.food_api

import com.arshtestproject.core.models.CategoryListModel
import com.arshtestproject.core.models.MealListModel
import com.arshtestproject.network.api.IBaseApi
import com.arshtestproject.network.dto.CategoryListDto
import com.arshtestproject.network.dto.MealListDto
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface FoodApi : IBaseApi {

    @GET("/api/json/v1/1/filter.php")
    fun getFoodByFilter(
        @Query("c") category: String = "chicken",
    ): Call<MealListDto>

    @GET("/api/json/v1/1/categories.php")
    fun getCategories(): Call<CategoryListDto>


}