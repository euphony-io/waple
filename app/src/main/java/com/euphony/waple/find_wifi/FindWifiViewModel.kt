package com.euphony.waple.find_wifi

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import euphony.lib.receiver.AcousticSensor
import euphony.lib.receiver.EuRxManager
import euphony.lib.transmitter.EuTxManager

class FindWifiViewModel : ViewModel() {

    private val txManager: EuTxManager by lazy {
        EuTxManager()
    }
    private val rxManager: EuRxManager by lazy {
        EuRxManager()
    }

    private val _isListening = MutableLiveData(false)
    val isListening get() = _isListening

    private val _listenResult = MutableLiveData("")
    val listenResult get() = _listenResult

    fun listen() {
        rxManager.listen()
        println("listen start")
        rxManager.acousticSensor = AcousticSensor {
            println("receive data: " + it)
            _listenResult.postValue(it)
            _isListening.postValue(true)
        }
    }

    fun finish(){
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