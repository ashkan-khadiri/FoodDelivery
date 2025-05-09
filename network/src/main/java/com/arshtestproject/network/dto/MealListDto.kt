package com.arshtestproject.network.dto

import com.arshtestproject.core.models.MealListModel

data class MealListDto(
    val meals: List<MealDto>,
) {
    fun convertToModel(): MealListModel {
        return MealListModel(
            meals = this.meals.map { x -> x.convertToModel() }
        )
    }
}