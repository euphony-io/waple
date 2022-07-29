package com.euphony.waple.find_wifi_fail.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.euphony.waple.R
import com.euphony.waple.Screen
import com.euphony.waple.ui.component.RectButton
import com.euphony.waple.ui.theme.Yellow

@Composable
fun FindWifiFailScreen(
    startScreenBtnClick: (Screen) -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = stringResource(id = R.string.look_for_wifi_fail),
            color = Yellow,
            fontWeight = FontWeight.Bold,
            fontSize = 36.sp
        )
        Image(
            modifier = Modifier
                .width(80.dp)
                .height(80.dp),
            painter = painterResource(id = R.drawable.waffle2),
            contentDescription = "waffle2"
        )
        RectButton(
            onClick = { startScreenBtnClick(Screen.HomeScreen) },
            backgroundColor = Color.Gray,
            text = stringResource(id = R.string.go_home)
        )
    }
}