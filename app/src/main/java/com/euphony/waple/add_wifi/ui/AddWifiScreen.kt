package com.euphony.waple.add_wifi.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.euphony.waple.R
import com.euphony.waple.ui.component.BasicDivider
import com.euphony.waple.ui.component.RectButton
import com.euphony.waple.ui.component.TitleText

@Preview
@Composable
fun AddWifiScreen() {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp)
            .verticalScroll(scrollState)
    ) {
        TitleText(titleResId = R.string.add_wifi)
        BasicDivider()
        Row() {

        }
        BasicDivider()
        RectButton(
            onClick = { /*TODO*/ },
            text = stringResource(id = R.string.finish)
        )
    }
}