package com.cencen.bloommate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.cencen.bloommate.ui.theme.BloomMateTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BloomMateTheme {
                BloomMateApp()
            }
        }
    }
}



