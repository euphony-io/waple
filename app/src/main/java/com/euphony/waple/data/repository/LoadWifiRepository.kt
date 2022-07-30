package com.euphony.waple.data.repository

import com.euphony.waple.data.WapleDataStore
import com.euphony.waple.data.WapleDataStore.KEY_PIN
import com.euphony.waple.data.WapleDataStore.KEY_STORE_NAME
import com.euphony.waple.data.WapleDataStore.KEY_WIFI_INFO
import com.euphony.waple.data.model.WifiAccount
import com.euphony.waple.data.model.WifiInfo

class LoadWifiRepository {

    private val localDataStore = WapleDataStore.adapter

    suspend fun saveWifiData(wifiInfo: WifiInfo?) {
        if (wifiInfo == null) {
            return
        }

        localDataStore.saveStringData(KEY_STORE_NAME, wifiInfo.storeName)
        localDataStore.saveList(KEY_PIN, wifiInfo.wifiList)
        localDataStore.saveIntData(KEY_STORE_NAME, wifiInfo.pin)
    }

    fun loadStoreName() = localDataStore.getStringData(KEY_STORE_NAME)

    fun loadWifiInfo() = localDataStore.getList<WifiAccount>(KEY_WIFI_INFO)

    fun loadPin() = localDataStore.getIntData(KEY_PIN)
}