package com.ultratools.app.ui.shell

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.ultratools.app.ui.home.HomeScreen

private enum class ShellSection {
    HOME,
    SEARCH,
    FAVORITES,
    SETTINGS
}

@Composable
fun UltraToolsApp() {

    var activeSection by rememberSaveable {
        mutableStateOf(ShellSection.HOME)
    }

    Surface(
        modifier = Modifier.fillMaxSize()
    ) {

        AnimatedContent(
            targetState = activeSection,
            transitionSpec = {
                fadeIn() togetherWith fadeOut()
            },
            label = "ultratools-shell"
        ) { destination ->

            Box(
                modifier = Modifier.fillMaxSize()
            ) {

                when (destination) {

                    ShellSection.HOME -> {
                        HomeScreen(
                            onSearchRequested = {
                                activeSection = ShellSection.SEARCH
                            },
                            onFavoritesRequested = {
                                activeSection = ShellSection.FAVORITES
                            },
                            onSettingsRequested = {
                                activeSection = ShellSection.SETTINGS
                            }
                        )
                    }

                    ShellSection.SEARCH -> {
                        PlaceholderSection(
                            title = "Search",
                            onBack = {
                                activeSection = ShellSection.HOME
                            }
                        )
                    }

                    ShellSection.FAVORITES -> {
                        PlaceholderSection(
                            title = "Favorites",
                            onBack = {
                                activeSection = ShellSection.HOME
                            }
                        )
                    }

                    ShellSection.SETTINGS -> {
                        PlaceholderSection(
                            title = "Settings",
                            onBack = {
                                activeSection = ShellSection.HOME
                            }
                        )
                    }
                }
            }
        }
    }
}
