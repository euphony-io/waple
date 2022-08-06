package com.euphony.waple.enter_PIN.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.euphony.waple.R
import com.euphony.waple.Screen
import com.euphony.waple.ui.component.RectButton
import com.euphony.waple.ui.theme.Yellow

@Composable
fun EnterPINScreen(
    startScreenBtnClick: String,
) {
    Column(
        modifier = androidx.compose.ui.Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            modifier = androidx.compose.ui.Modifier.padding(top = 20.dp, bottom = 50.dp),
            text = "Wi-Fi 사용 권한을 얻으려면 PIN 번호를 입력해주세요!",
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        )

        TextFieldWithLabel(
            titleResId = R.string.pin_num,
            hintResId = R.string.pin_hint,
            keyboardType = KeyboardType.Number
        ){}

        RectButton(
            onClick = { },
            backgroundColor = Yellow,
            text = "확인"
        )
    }
}



