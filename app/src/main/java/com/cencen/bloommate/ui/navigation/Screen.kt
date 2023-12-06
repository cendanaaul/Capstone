package com.cencen.bloommate.ui.navigation

sealed class Screen (val routes: String) {
    object Main : Screen("main")
    object Home : Screen("home")
    object Cart : Screen("cart")
    object Dictionary : Screen("dictionary")
    object Profile : Screen("profile")
    object DetailProduct : Screen("home/{flowersId}") {
        fun createRoutes(flowersId: Long) = "main/$flowersId"
    }
    object DetailDictionary : Screen("dictionary/{flowerId}") {
        fun createRoutes(flowerId: Long) = "dictionary/$flowerId"
    }
}