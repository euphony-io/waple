package com.euphony.waple

import com.euphony.waple.data.model.WifiAccount
import org.junit.Test
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.DisplayName

class WifiAccountTest {

    @Test
    @DisplayName("Wifi Account 객체 생성 테스트")
    fun testCreateWifiAccount() {
        val wifiAccount = WifiAccount("name", "password")
        assertEquals(wifiAccount.name, "name")
        assertEquals(wifiAccount.password, "password")
    }

    @Test
    @DisplayName("name의 길이는 1 이상이어야 한다")
    fun testWifiAccountName() {
        assertThrows(IllegalStateException::class.java) {
            WifiAccount("", "asdf")
        }
    }

    @Test
    @DisplayName("password의 길이는 1 이상이어야 한다")
    fun testWifiAccountPwd() {
        assertThrows(IllegalStateException::class.java) {
            WifiAccount("asdf", "")
        }
    }
}