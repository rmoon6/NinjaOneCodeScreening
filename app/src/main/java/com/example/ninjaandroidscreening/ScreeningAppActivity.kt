package com.example.ninjaandroidscreening

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.ninjaandroidscreening.theme.NinjaAndroidScreeningTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ScreeningAppActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent { MainActivityContent() }
    }

    @Composable
    private fun MainActivityContent() {
        NinjaAndroidScreeningTheme {
            ScreeningApp(
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}
