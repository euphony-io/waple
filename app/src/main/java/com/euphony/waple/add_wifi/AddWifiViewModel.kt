package com.euphony.waple.add_wifi

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.euphony.waple.R
import com.euphony.waple.WIFI_MAX_COUNT
import com.euphony.waple.WIFI_MIN_COUNT
import com.euphony.waple.data.model.WifiAccount
import com.euphony.waple.data.model.WifiInfo
import com.euphony.waple.data.repository.LoadWifiRepository
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.launch

class AddWifiViewModel : ViewModel() {

    private val repository = LoadWifiRepository()

    private val _toastMsgId = MutableLiveData<Int?>()
    val toastMsgId: LiveData<Int?> = _toastMsgId

    private val _wifiInfo = MutableLiveData<WifiInfo>()
    val wifiInfo: LiveData<WifiInfo> = _wifiInfo

    var wifiNames = mutableStateListOf<String>("", "")
        private set

    var wifiPwds = mutableStateListOf<String>("", "")
        private set

    init {
        init()
    }

    private fun init() {
        viewModelScope.launch {
            _toastMsgId.value = null
            val data = WifiInfo(
                repository.loadStoreName().firstOrNull() ?: "",
                repository.loadWifiInfo().firstOrNull() ?: listOf(),
                repository.loadPin().firstOrNull(),
            )
            _wifiInfo.value = data
            data.wifiList.take(WIFI_MAX_COUNT).mapIndexed { index, item ->
                wifiNames[index] = item.name
            }
            data.wifiList.take(WIFI_MAX_COUNT).mapIndexed { index, item ->
                wifiPwds[index] = item.password
            }
        }
    }

    fun submit(
        storeName: String?,
        wifiInfo: List<WifiAccount>,
        pin: String?
    ) {
        if (isSubmitAvailable(storeName, wifiInfo, pin)) return

        val data = WifiInfo(
            storeName ?: "",
            wifiInfo.filter { checkWifiAccount(it) },
            pin?.toIntOrNull()
        )

        viewModelScope.launch {
            _wifiInfo.value = data
            repository.saveWifiData(data)
        }
    }

    private fun isSubmitAvailable(
        storeName: String?,
        wifiInfo: List<WifiAccount>,
        pin: String?
    ): Boolean {
        if (!checkStoreName(storeName)) {
            _toastMsgId.value = R.string.store_name_empty
            return true
        }
        if (!checkWifiInfo(wifiInfo)) {
            _toastMsgId.value = R.string.store_name_empty
            return true
        }
        if (!checkPinNumber(pin)) {
            _toastMsgId.value = R.string.pin_length_low
            return true
        }
        return false
    }

    private fun checkStoreName(storeName: String?) = storeName?.isNotBlank() == true

    private fun checkWifiInfo(wifiInfo: List<WifiAccount>) =
        wifiInfo.count { info -> checkWifiAccount(info) } in WIFI_MIN_COUNT..WIFI_MAX_COUNT

    private fun checkWifiAccount(wifiAccount: WifiAccount) =
        wifiAccount.name.isNotBlank() && wifiAccount.password.isNotBlank()

    private fun checkPinNumber(pin: String?) =
        pin.isNullOrBlank() || (pin.length == 2 && pin.all { it.isDigit() })
}