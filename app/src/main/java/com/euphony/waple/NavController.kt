package com.euphony.waple

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.euphony.waple.add_wifi.ui.AddWifiScreen
import com.euphony.waple.find_wifi.ui.FindWifiScreen
import com.euphony.waple.find_wifi_fail.ui.FindWifiFailScreen
import com.euphony.waple.home.ui.HomeScreen
import com.euphony.waple.ui.theme.WapleTheme

@Composable
fun NavController() {
    val navController = rememberNavController()

    WapleTheme {
        Scaffold(
            modifier = Modifier.fillMaxSize()
        ) {
            NavHost(
                navController = navController,
                Screen.HomeScreen.route,
                modifier = Modifier.fillMaxSize()
            )
            {
                composable(route = Screen.HomeScreen.route) {
                    HomeScreen {
                        navController.navigate(it.route)
                    }
                }
                composable(route = Screen.AddWifiScreen.route) {
                    AddWifiScreen()
                }
                composable(route = Screen.FindWifiScreen.route) {
                    FindWifiScreen {
                        navController.navigate(it.route)
                    }
                }
                composable(route = Screen.FindWifiFailScreen.route) {
                    FindWifiFailScreen{
                        navController.navigate(it.route)
                    }
                }
            }
        }
    }
}