package com.cencen.bloommate.ui.screen.dictionary

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.cencen.bloommate.ui.theme.BloomMateTheme

@Composable
fun DictionaryScreen() {
    Surface(
        color = Color(0xFFF5F5F),
        modifier = Modifier.fillMaxSize()
    ) {
        Box(modifier = Modifier.fillMaxSize()) {

        }
    }
}

@Preview
@Composable
fun DictionaryScreenPreview() {
    BloomMateTheme {
        DictionaryScreen()
    }
}