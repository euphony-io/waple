package com.euphony.waple.find_wifi

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import euphony.lib.receiver.AcousticSensor
import euphony.lib.receiver.EuRxManager
import euphony.lib.transmitter.EuTxManager

class FindWifiViewModel : ViewModel() {

    private val txManager: EuTxManager = EuTxManager()
    private val rxManager: EuRxManager = EuRxManager()

    private var _listenResult = MutableLiveData("")
    val listenResult get() = _listenResult

    fun listen() {
        _listenResult = MutableLiveData("")
        rxManager.listen()
        Log.i("listen start", "listen start")
        rxManager.acousticSensor = AcousticSensor {
            Log.i("receive data", it)
            _listenResult.postValue(it)
        }

    }

    fun finish() {
        rxManager.finish()
    }

    fun speak(textToSend: String) {
        txManager.euInitTransmit(textToSend)
        Log.i("speak start", "speak start")
        txManager.process(-1)
    }

    fun stop() {
        txManager.stop()
    }
}