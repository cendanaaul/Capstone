package com.cencen.bloommate.ui.login

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.cencen.bloommate.R
import com.cencen.bloommate.ui.theme.BloomMateTheme

@Composable
fun LoginScreen() {
    Column() {
        Text(text = stringResource(id = R.string.welcome))
    }
}

@Preview (showBackground = true, device = Devices.PIXEL_4)
@Composable
fun LoginScreenPreview() {
    BloomMateTheme {
        LoginScreen()
    }
}