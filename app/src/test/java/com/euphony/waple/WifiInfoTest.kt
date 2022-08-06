package com.euphony.waple

import com.euphony.waple.data.model.WifiAccount
import com.euphony.waple.data.model.WifiInfo
import org.junit.Test
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.DisplayName

class WifiInfoTest {

    @Test
    @DisplayName("WifiInfo 객체 생성 테스트")
    fun testCreateWifiInfo() {
        val wifiInfo = WifiInfo(
            "store",
            listOf(
                WifiAccount("name", "pwd")
            ),
            null
        )
        assertEquals(wifiInfo.storeName, "store")
        assertEquals(wifiInfo.wifiList, listOf(WifiAccount("name", "pwd")))
        assertNull(wifiInfo.pin)
    }
}