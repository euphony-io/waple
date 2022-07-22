package com.euphony.waple.home.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.euphony.waple.R
import com.euphony.waple.ui.component.HomeButton
import com.euphony.waple.ui.theme.Yellow

@Composable
fun HomeScreen(
    addWifiClick: () -> Unit,
    findWifiClick: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = stringResource(id = R.string.app_name),
            color = Yellow,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic,
            fontSize = 36.sp
        )
        Text(
            modifier = Modifier.padding(top = 8.dp, bottom = 48.dp),
            text = stringResource(id = R.string.app_description),
            color = Color.Gray,
            fontWeight = FontWeight.Bold
        )
        HomeButton(
            onClick = addWifiClick,
            backgroundColor = Yellow,
            text = stringResource(id = R.string.add_wifi)
        )
        HomeButton(
            onClick = findWifiClick,
            backgroundColor = Color.Gray,
            text = stringResource(id = R.string.find_wifi)
        )
    }
}