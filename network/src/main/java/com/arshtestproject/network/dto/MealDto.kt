package com.arshtestproject.network.dto

import com.arshtestproject.core.models.MealModel


data class MealDto(
    val idMeal: String,
    val strMeal: String,
    val strMealThumb: String,
) {
    fun convertToModel(): MealModel {
        return MealModel(
            idMeal = this.idMeal,
            strMeal = this.strMeal,
            strMealThumb = this.strMealThumb,
        )
    }
}