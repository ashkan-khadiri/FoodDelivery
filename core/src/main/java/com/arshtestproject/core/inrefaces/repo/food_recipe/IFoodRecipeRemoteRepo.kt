package com.arshtestproject.core.inrefaces.repo.food_recipe

import com.arshtestproject.core.models.CategoryListModel
import com.arshtestproject.core.models.MealListModel

interface IFoodRecipeRemoteRepo {

    suspend fun getFoodByFilter(filter: String): MealListModel

    suspend fun getCategory(): CategoryListModel
}