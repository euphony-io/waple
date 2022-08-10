package com.euphony.waple.wifi_list.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.euphony.waple.R
import com.euphony.waple.Screen
import com.euphony.waple.WIFI_MIN_COUNT
import com.euphony.waple.enter_PIN.ui.TextFieldWithLabel
import com.euphony.waple.ui.theme.Yellow
import com.euphony.waple.wifi_list.WifiListViewModel
import com.euphony.waple.ui.component.BasicDivider
import com.euphony.waple.ui.component.RectButton
import androidx.compose.material.Text

@Composable
fun WifiListScreen(
    viewModel : WifiListViewModel,
    startScreenBtnClick: (Screen) -> Unit
) {
    var wifiListCount by remember { mutableStateOf(WIFI_MIN_COUNT) }
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 32.dp, horizontal = 24.dp)
                    .verticalScroll(scrollState)
            ) {
                Text(
                text = stringResource(id = R.string.available_wifi),
                color = Color.Gray,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
                Row(
                    modifier = Modifier
                        .padding(12.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                )
                    {
                    Icon(
                        painter = painterResource(id = R.drawable.waffle2),
                        //와플 이미지 추가
                        contentDescription = "waffle2"
                    )
                    Spacer(modifier = Modifier.width(8.dp))

                    BasicDivider()
                        SelectionContainer {
                        repeat(wifiListCount) {
                        RectButton(
                            onClick = { },
                            backgroundColor = Yellow,
                            text = stringResource(id = R.string.store_name_hint)
                        )
                    }
                }
            }

        RectButton(
            onClick = {
                startScreenBtnClick(Screen.HomeScreen)
            },
            backgroundColor = Color.Gray,
            text = stringResource(id = R.string.go_home)
        )
            }
        }
    }
}



