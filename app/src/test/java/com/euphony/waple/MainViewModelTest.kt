package com.euphony.waple

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.*
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class MainViewModelTest {

    private lateinit var viewModel: MainViewModel

    private val testDispatcher = StandardTestDispatcher(TestCoroutineScheduler())
    private val testScope = TestScope(testDispatcher)

    @Before
    fun setup() {
        viewModel = MainViewModel()
        Dispatchers.setMain(testDispatcher)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `test clickButton`() = testScope.runTest {
        viewModel.tempForViewModelTest(Screen.AddWifiScreen).join()
        assertEquals(viewModel.testEvent.value, Screen.AddWifiScreen)
    }
}