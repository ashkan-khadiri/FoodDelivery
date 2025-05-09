package com.arshtestproject.network.repository

import com.arshtestproject.core.inrefaces.repo.food_recipe.IFoodRecipeRemoteRepo
import com.arshtestproject.core.models.CategoryListModel
import com.arshtestproject.core.models.MealListModel
import com.arshtestproject.network.api.food_api.FoodApi

class FoodRecipeRemoteRepo(private val foodApi: FoodApi) : BaseRemoteRepo(), IFoodRecipeRemoteRepo {

    override suspend fun getFoodByFilter(filter: String): MealListModel {
        return getResponse(foodApi.getFoodByFilter(filter))?.convertToModel()
            ?: MealListModel(meals = emptyList())
    }

    override suspend fun getCategory(): CategoryListModel {
        return getResponse(foodApi.getCategories())?.convertToModel()
            ?: CategoryListModel(categories = emptyList())
    }

}