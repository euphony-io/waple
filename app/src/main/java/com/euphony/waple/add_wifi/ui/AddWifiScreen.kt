package com.euphony.waple.add_wifi.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.euphony.waple.R
import com.euphony.waple.WIFI_MAX_COUNT
import com.euphony.waple.WIFI_MIN_COUNT
import com.euphony.waple.add_wifi.AddWifiViewModel
import com.euphony.waple.ui.component.BasicDivider
import com.euphony.waple.ui.component.RectButton
import com.euphony.waple.ui.component.TitleText

@Preview
@Composable
fun AddWifiScreen() {

    var wifiFieldCount by remember { mutableStateOf(WIFI_MIN_COUNT) }

    val viewModel = AddWifiViewModel()

    val scrollState = rememberScrollState()

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
            Row(
                modifier = Modifier
                    .padding(12.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                TitleText(
                    titleResId = R.string.add_wifi
                )
            }
            BasicDivider()
            TextFieldWithLabel(
                titleResId = R.string.store_name,
                hintResId = R.string.store_name_hint
            ) {

            }
            BasicDivider()
            repeat(wifiFieldCount) {
                TextFieldWithLabel(
                    titleResId = R.string.wifi_name,
                    hintResId = R.string.wifi_name_hint,
                ) {

                }
                TextFieldWithLabel(
                    titleResId = R.string.wifi_pw,
                    hintResId = R.string.wifi_pw_hint,
                    KeyboardType.Password
                ) {

                }
            }
            AnimatedVisibility(visible = wifiFieldCount < WIFI_MAX_COUNT) {
                AddWifiButton() {
                    wifiFieldCount++
                }
            }
            BasicDivider()
            TextFieldWithLabel(
                titleResId = R.string.pin,
                hintResId = R.string.pin_hint,
                KeyboardType.Number
            ) {

            }
        }
        RectButton(
            onClick = { /*TODO*/ },
            text = stringResource(id = R.string.finish)
        )
    }
}
