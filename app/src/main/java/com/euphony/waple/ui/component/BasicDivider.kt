package com.euphony.waple.ui.component

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun BasicDivider() {
    androidx.compose.material.Divider(
        modifier = Modifier.padding(vertical = 8.dp),
        color = Color.DarkGray,
        thickness = 1.dp
    )
}