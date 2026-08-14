package com.ultratools.app.ui.navigation

sealed class AppDestination(
    val route: String
) {

    data object Home : AppDestination("home")

    data object Search : AppDestination("search")

    data object Favorites : AppDestination("favorites")

    data object Settings : AppDestination("settings")
}
