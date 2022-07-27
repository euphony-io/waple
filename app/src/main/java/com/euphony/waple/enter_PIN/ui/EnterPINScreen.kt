package com.euphony.waple.enter_PIN.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.euphony.waple.Screen
import com.euphony.waple.ui.component.HomeButton
import com.euphony.waple.ui.theme.Yellow
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import com.euphony.waple.ui.theme.PurpleGrey40

@Preview
@Composable
fun EnterPINScreen(
    startScreenBtnClick: Screen.WifiListScreen,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            modifier = Modifier.padding(top = 8.dp, bottom = 48.dp),
            text = "Wi-Fi 사용 권한을 얻으려면 PIN 번호를 입력해주세요!",
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )

        @Composable
        fun TextFieldTest() {
            var pinInput by remember { mutableStateOf(TectFieldValue()) }

            Column(
                Modifier.padding(16.dp)
                    .fillMaxWidth()
            ) {

                OutlinedTextField(
                    modifier = java.lang.reflect.Modifier.fillMaxWidth(),
                    value = pinInput,
                    singleLine = true,
                    maxLines = 1,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    onValueChange = { newValue -> pinInput = newValue },
                    label = "PIN 번호",
                    placeHolder = "ex)1234"
                )
            }
        }

        HomeButton(
            onClick = { startScreenBtnClick(Screen.WifiListScreen) },
            backgroundColor = Yellow,
            text = "확인"
        )
    }
}




