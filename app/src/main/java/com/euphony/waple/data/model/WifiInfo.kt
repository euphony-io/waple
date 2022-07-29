package com.euphony.waple.data.model

data class WifiInfo(
    val storeName: String,
    val wifiList: List<WifiAccount>,
    val pin: Int? = null
)