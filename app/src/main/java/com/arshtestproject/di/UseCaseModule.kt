package com.arshtestproject.di

import com.arshtestproject.core.inrefaces.ICoroutineContextProvider
import com.arshtestproject.core.inrefaces.repo.food_recipe.IFoodRecipeRemoteRepo
import com.arshtestproject.core.intractors.food_api_usecases.GetCategoryUseCases
import com.arshtestproject.core.intractors.food_api_usecases.GetFoodByFilterUseCases
import com.arshtestproject.network.api.food_api.FoodApi
import com.arshtestproject.network.repository.FoodRecipeRemoteRepo
import com.arshtestproject.presentation.utils.CoroutineContextProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object UseCaseModule {

    @Provides
    fun provideGetFoodByFilterUseCase(
        foodRecipeRemoteRepo: IFoodRecipeRemoteRepo,
    ): GetFoodByFilterUseCases {
        return GetFoodByFilterUseCases(
            foodRecipeRemoteRepo
        )
    }

    @Provides
    fun provideGetCategoryUseCases(
        foodRecipeRemoteRepo: IFoodRecipeRemoteRepo,
    ): GetCategoryUseCases {
        return GetCategoryUseCases(
            foodRecipeRemoteRepo
        )
    }

    @Provides
    fun provideICoroutineContextProvider(): ICoroutineContextProvider {
        return CoroutineContextProvider()
    }
}