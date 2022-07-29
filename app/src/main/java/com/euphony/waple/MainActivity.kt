package com.euphony.waple

import android.Manifest
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.app.ActivityCompat

class MainActivity : ComponentActivity() {

    private val permissions: Array<String> = arrayOf(
        Manifest.permission.RECORD_AUDIO,
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ActivityCompat.requestPermissions(this, permissions, 0)
        setContent {
            NavController()
        }
    }
}