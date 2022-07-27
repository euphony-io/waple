package com.euphony.waple.wifi_list.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.euphony.waple.R
import com.euphony.waple.Screen
import com.euphony.waple.ui.component.HomeButton
import com.euphony.waple.ui.theme.Yellow

@Composable
fun WifiListScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "사용 가능한 Wi-Fi 목록",
            color = Color.Gray,
            fontWeight = FontWeight.Bold,
            fontSize = 25.sp
        )

        OutlinedButton(
            onClick = { },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.LightGray,
                contentColor = Color.Black
            ),
            contentPadding = PaddingValues(12.dp),
        ) {
            Icon(
                painter = painterResource(id = R.drawable.),
                //와플 이미지 추가
                contentDescription = ""
            )
            Spacer(modifier = java.lang.reflect.Modifier.width(8.dp))
            Text("Wi-Fi 이름 예시")
        }

        HomeButton(
            onClick = { startScreenBtnClick(Screen.HomeScreen) },
            backgroundColor = Color.Gray,
            text = "홈화면으로"
        )
    }
}
