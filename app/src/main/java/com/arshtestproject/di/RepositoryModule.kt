package com.arshtestproject.di

import com.arshtestproject.core.inrefaces.repo.food_recipe.IFoodRecipeRemoteRepo
import com.arshtestproject.network.api.food_api.FoodApi
import com.arshtestproject.network.repository.FoodRecipeRemoteRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideTvSeriesRepository(
        foodApi: FoodApi,
    ): IFoodRecipeRemoteRepo {
        return FoodRecipeRemoteRepo(
            foodApi
        )
    }

}