package com.euphony.waple.ui.component

import androidx.annotation.StringRes
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.euphony.waple.ui.theme.Yellow

@Composable
fun TitleText(
    @StringRes titleResId: Int
) {
    Text(
        text = stringResource(titleResId),
        color = Yellow,
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold
    )
}