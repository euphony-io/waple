package com.euphony.waple.find_wifi

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import euphony.lib.receiver.AcousticSensor
import euphony.lib.receiver.EuRxManager
import euphony.lib.transmitter.EuTxManager
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class FindWifiViewModel : ViewModel() {

    private val txManager: EuTxManager = EuTxManager()
    private val rxManager: EuRxManager = EuRxManager()

    var ticks = 0

    private var _listenResult = MutableLiveData("")
    val listenResult get() = _listenResult

    private var _listenFinished = MutableLiveData(false)
    val listenFinished get() = _listenFinished

    fun listen() {
        ticks = 0
        _listenFinished.postValue(false)
        checkTime()
        _listenResult = MutableLiveData("")
        rxManager.listen()
        Log.i("listen", "start")
        rxManager.acousticSensor = AcousticSensor {
            Log.i("receive data", it)
            _listenResult.postValue(it)
        }

    }

    fun finish() {
        Log.i("listen", "finish")
        rxManager.finish()
    }

    fun checkTime() {
        viewModelScope.launch {
            while (true) {
                delay(1000)
                ticks++
                if (ticks >= 10) {
                    _listenFinished.postValue(true)
                }
            }
        }

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