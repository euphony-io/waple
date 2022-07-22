package com.euphony.waple

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val _testEvent = MutableStateFlow<Screen?>(null)
    val testEvent: StateFlow<Screen?>
        get() = _testEvent

    fun tempForViewModelTest(screen: Screen) = viewModelScope.launch {
        _testEvent.emit(screen)
    }
}