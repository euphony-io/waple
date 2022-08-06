package com.euphony.waple

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.euphony.waple.add_wifi.AddWifiViewModel
import com.euphony.waple.data.model.WifiAccount
import com.euphony.waple.util.getOrAwaitValue
import org.junit.Rule
import org.junit.Test
import org.junit.jupiter.api.Assertions.assertEquals

class AddWifiViewModelTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    private val viewModel: AddWifiViewModel = AddWifiViewModel()

    @Test
    fun testStoreNameCantEmpty() {
        viewModel.submit("", listOf(), null)
        assertEquals(viewModel.toastMsgId.getOrAwaitValue(), R.string.store_name_empty)
    }

    @Test
    fun testWifiMinCount() {
        viewModel.submit("aaa", listOf(), null)
        assertEquals(viewModel.toastMsgId.getOrAwaitValue(), R.string.store_name_empty)
    }

    @Test
    fun testPinLength() {
        viewModel.submit("aaa", listOf(WifiAccount("aa", "aa")), "1")
        assertEquals(viewModel.toastMsgId.getOrAwaitValue(), R.string.pin_length_low)
    }
}