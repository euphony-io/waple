package com.euphony.waple.enter_PIN.ui

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.euphony.waple.*
import com.euphony.waple.enter_PIN.EnterPINViewModel
import com.euphony.waple.ui.component.RectButton
import com.euphony.waple.ui.theme.Yellow

@Composable
fun EnterPINScreen(
    viewModel: EnterPINViewModel,
    startScreenBtnClick: (Screen) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            modifier = Modifier.padding(top = 20.dp, bottom = 50.dp),
            text = "Wi-Fi 사용 권한을 얻으려면 PIN 번호를 입력해주세요!",
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        )
        TextFieldWithLabel(
            titleResId = R.string.pin_num,
            hintResId = R.string.pin_hint,
            keyboardType = KeyboardType.Number
        ){

        }

        RectButton(
            onClick = {
                /*TODO: WIFI 비밀번호 보여주는 화면으로*/},
            backgroundColor = Yellow,
            text = "확인"
        )
    }
    if ( PIN_MIN_LENGTH != "TextFieldWithLabel로입력받은PIN".length) {
        Toast.makeText(
            WapleApplication.getContext(),
            "PIN 번호를 입력해주세요!",
            Toast.LENGTH_SHORT
        ).show()
    }

    if ( PIN_MAX_LENGTH < "TextFieldWithLabel로입력받은PIN".length) {
        Toast.makeText(
            WapleApplication.getContext(),
            "PIN 번호는 최대 2글자에요",
            Toast.LENGTH_SHORT
        ).show()
    }

    if ( "TextFieldWithLabel로입력받은PIN"!="정답인PIN") {
        Toast.makeText(
            WapleApplication.getContext(),
            "PIN 번호가 틀렸습니다.",
            Toast.LENGTH_SHORT
        ).show()
    }

}


