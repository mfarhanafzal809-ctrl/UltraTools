package com.ultratools.app.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val UltraDarkScheme = darkColorScheme(
    primary = UltraPrimary,
    onPrimary = UltraTextPrimary,
    secondary = UltraSecondary,
    background = UltraBackgroundDark,
    onBackground = UltraTextPrimary,
    surface = UltraSurfaceDark,
    onSurface = UltraTextPrimary,
    surfaceVariant = UltraSurfaceVariantDark,
    onSurfaceVariant = UltraTextSecondary,
    error = UltraError
)

private val UltraLightScheme = lightColorScheme(
    primary = UltraPrimary,
    onPrimary = UltraTextPrimary,
    secondary = UltraSecondary,
    background = UltraBackgroundLight,
    onBackground = ColorTokens.LightTextPrimary,
    surface = UltraSurfaceLight,
    onSurface = ColorTokens.LightTextPrimary,
    surfaceVariant = UltraSurfaceVariantLight,
    onSurfaceVariant = ColorTokens.LightTextSecondary,
    error = UltraError
)

private object ColorTokens {
    val LightTextPrimary = androidx.compose.ui.graphics.Color(0xFF151821)
    val LightTextSecondary = androidx.compose.ui.graphics.Color(0xFF5F6573)
}

@Composable
fun UltraToolsTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val context = LocalContext.current

    val colorScheme =
        when {
            dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
                if (darkTheme) {
                    androidx.compose.material3.dynamicDarkColorScheme(context)
                } else {
                    androidx.compose.material3.dynamicLightColorScheme(context)
                }
            }

            darkTheme -> UltraDarkScheme

            else -> UltraLightScheme
        }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = UltraTypography,
        content = content
    )
}
