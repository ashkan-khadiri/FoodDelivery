package com.arshtestproject.network.dto

import com.arshtestproject.core.models.CategoryListModel

data class CategoryListDto(
    val categories: List<CategoryDto>,
) {
    fun convertToModel(): CategoryListModel {
        return CategoryListModel(
            categories = categories.map { x -> x.convertToModel() }
        )
    }
}