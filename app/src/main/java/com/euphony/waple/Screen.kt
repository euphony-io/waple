package com.euphony.waple

import androidx.annotation.StringRes

sealed class Screen(
    val route: String,
    @StringRes val resourceId: Int
) {
    object HomeScreen : Screen("HomeScreen", R.string.app_name)
    object AddWifiScreen : Screen("AddWifiScreen", R.string.add_wifi)
    object FindWifiScreen : Screen("FindWifiScreen", R.string.find_wifi)
    object FindWifiFailScreen : Screen("FindWifiFailScreen", R.string.look_for_wifi_fail)
    object EnterPINScreen : Screen("EnterPINScreen", R.string.enter_PIN)
    object WifiListScreen : Screen("WifiListScreen", R.string.wifi_list)
}