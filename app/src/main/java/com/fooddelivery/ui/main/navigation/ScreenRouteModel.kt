package com.fooddelivery.ui.main.navigation

sealed class ScreenRouteModel(val rout: String) {
    data object Home: ScreenRouteModel("home_screen")
    data object Profile: ScreenRouteModel("profile_screen")
    data object Cart: ScreenRouteModel("cart_screen")
    data object Setting: ScreenRouteModel("setting_screen")
}