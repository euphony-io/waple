package com.euphony.waple.add_wifi.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.euphony.waple.R
import com.euphony.waple.add_wifi.AddWifiViewModel
import com.euphony.waple.ui.component.HomeButton
import com.euphony.waple.ui.theme.Yellow

@Composable
fun AddWifiScreen() {
    val viewModel = AddWifiViewModel()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        HomeButton(
            onClick = { viewModel.speak("test hello hello") },
            backgroundColor = Yellow,
            text = stringResource(id = R.string.add_wifi)
        )
    }
}