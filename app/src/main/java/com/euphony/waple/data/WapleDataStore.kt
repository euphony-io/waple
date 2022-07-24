package com.euphony.waple.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.euphony.waple.WapleApplication

object WapleDataStore {

    private const val DATASTORE_NAME = "waple"
    const val KEY_STORE_NAME: String = "key_store_name"
    const val KEY_PIN: String = "key_pin"
    const val KEY_WIFI_INFO: String = "key_wifi_info"

    val Context.dataStore: DataStore<Preferences> by preferencesDataStore(DATASTORE_NAME)

    val adapter = LocalDataStore(dataStore = WapleApplication.getContext().dataStore)
}