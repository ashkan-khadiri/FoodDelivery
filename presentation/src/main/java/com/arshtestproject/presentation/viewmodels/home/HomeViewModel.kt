package com.arshtestproject.presentation.viewmodels.home

import com.arshtestproject.core.inrefaces.ICoroutineContextProvider
import com.arshtestproject.core.intractors.food_api_usecases.GetCategoryUseCases
import com.arshtestproject.core.intractors.food_api_usecases.GetFoodByFilterUseCases
import com.arshtestproject.core.models.CategoryListModel
import com.arshtestproject.core.models.CategoryModel
import com.arshtestproject.core.models.MealListModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getFoodByFilterUseCases: GetFoodByFilterUseCases,
    private val categoryUseCases: GetCategoryUseCases,
    override val contextProvider: ICoroutineContextProvider,
) : BaseViewModel(contextProvider) {

    private val _data = MutableStateFlow<MealListModel?>(null)
    val data: StateFlow<MealListModel?> = _data

    private val _categoryData = MutableStateFlow<CategoryListModel?>(null)
    val categoryData: StateFlow<CategoryListModel?> = _categoryData

    fun getFoodByFilter(category: String) {
        launchCoroutineIO {
            val result = getFoodByFilterUseCases.invoke(category)

            _data.emit(result)
        }
    }

    fun getCategoryUseCases() {
        launchCoroutineIO {
            val result = categoryUseCases.invoke()

            _categoryData.emit(result)
        }
    }

    override fun onCoroutineError(exception: Throwable) {

    }

}