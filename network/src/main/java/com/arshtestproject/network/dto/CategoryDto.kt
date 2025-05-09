package com.arshtestproject.network.dto

import com.arshtestproject.core.models.CategoryModel

data class CategoryDto(
    val idCategory: String,
    val strCategory: String,
    val strCategoryDescription: String,
    val strCategoryThumb: String
) {
    fun convertToModel(): CategoryModel {
        return CategoryModel(
            idCategory = idCategory,
            strCategory = strCategory,
            strCategoryDescription = strCategoryDescription,
            strCategoryThumb = strCategoryThumb
        )
    }
}