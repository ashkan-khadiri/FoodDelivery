package com.arshtestproject.core.intractors.food_api_usecases

import com.arshtestproject.core.inrefaces.repo.food_recipe.IFoodRecipeRemoteRepo
import com.arshtestproject.core.intractors.BaseUseCase
import com.arshtestproject.core.models.MealListModel


class GetFoodByFilterUseCases(
    private val foodRecipeRemoteRepo: IFoodRecipeRemoteRepo,
) : BaseUseCase<String, MealListModel> {

    override suspend fun invoke(params: String): MealListModel {
        return foodRecipeRemoteRepo.getFoodByFilter(params)
    }

}
