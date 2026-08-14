package com.ultratools.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.ultratools.app.ui.shell.UltraToolsApp
import com.ultratools.app.ui.theme.UltraToolsTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        installSplashScreen()

        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            UltraToolsTheme {
                UltraToolsApp()
            }
        }
    }
}
