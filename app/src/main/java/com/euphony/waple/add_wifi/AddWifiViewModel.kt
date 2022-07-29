package com.euphony.waple.add_wifi

import androidx.lifecycle.ViewModel
import euphony.lib.transmitter.EuTxManager

class AddWifiViewModel : ViewModel() {

    private val txManager: EuTxManager by lazy {
        EuTxManager()
    }

    fun speak(textToSend: String) {
        txManager.euInitTransmit(textToSend)
        txManager.process(-1)
    }

    fun stop() {
        txManager.stop()
    }
}