package com.euphony.waple.add_wifi.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.euphony.waple.PIN_MAX_LENGTH
import com.euphony.waple.R
import com.euphony.waple.WIFI_MAX_COUNT
import com.euphony.waple.WIFI_MIN_COUNT
import com.euphony.waple.add_wifi.AddWifiViewModel
import com.euphony.waple.common.ToastUtils
import com.euphony.waple.ui.component.BasicDivider
import com.euphony.waple.ui.component.RectButton
import com.euphony.waple.ui.component.TitleText

@Preview
@Composable
fun AddWifiScreen() {

    val viewModel = AddWifiViewModel()
    val toastMsgId by viewModel.toastMsgId.observeAsState()

    var wifiFieldCount by remember { mutableStateOf(WIFI_MIN_COUNT) }
    var storeName by remember { mutableStateOf("") }
    var pin by remember { mutableStateOf("") }

    val scrollState = rememberScrollState()

    LaunchedEffect(toastMsgId) {
        if (toastMsgId != null) {
            ToastUtils.showToast(toastMsgId!!)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 32.dp, horizontal = 24.dp)
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
                hintResId = R.string.store_name_hint,
                value = storeName
            ) {
                storeName = it
            }
            BasicDivider()
            repeat(wifiFieldCount) { index ->
                TextFieldWithLabel(
                    titleResId = R.string.wifi_name,
                    hintResId = R.string.wifi_name_hint,
                    value = viewModel.wifiNames[index],
                ) {
                    viewModel.wifiNames[index] = it
                }
                TextFieldWithLabel(
                    titleResId = R.string.wifi_pw,
                    hintResId = R.string.wifi_pw_hint,
                    KeyboardType.Password,
                    value = viewModel.wifiPwds[index],
                ) {
                    viewModel.wifiPwds[index] = it
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
                KeyboardType.Number,
                pin
            ) {
                pin = if (it.length <= PIN_MAX_LENGTH) it else pin
            }
        }
        RectButton(
            onClick = {
                viewModel.submit(
                    storeName,
                    listOf(),
                    pin
                )
            },
            text = stringResource(id = R.string.finish)
        )
    }


}
