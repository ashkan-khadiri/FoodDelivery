package com.arshtestproject.core.intractors.food_api_usecases

import com.arshtestproject.core.inrefaces.repo.food_recipe.IFoodRecipeRemoteRepo
import com.arshtestproject.core.intractors.BaseUseCase
import com.arshtestproject.core.intractors.BaseUseCaseOf
import com.arshtestproject.core.models.CategoryListModel


class GetCategoryUseCases(
    private val foodRecipeRemoteRepo: IFoodRecipeRemoteRepo,
) : BaseUseCaseOf<CategoryListModel> {

    override suspend fun invoke(): CategoryListModel {
        return foodRecipeRemoteRepo.getCategory()
    }

}
