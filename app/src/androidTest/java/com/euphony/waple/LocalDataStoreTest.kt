package com.euphony.waple

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStoreFile
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.euphony.waple.data.LocalDataStore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.test.*
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
class LocalDataStoreTest {

    private val testContext = InstrumentationRegistry.getInstrumentation().targetContext
    private val testDispatcher = StandardTestDispatcher(TestCoroutineScheduler())
    private val testScope = TestScope(testDispatcher)

    private val testDataStore: DataStore<Preferences> =
        PreferenceDataStoreFactory.create(
            scope = testScope,
            produceFile = { testContext.preferencesDataStoreFile("test") }
        )

    private val localDataStore = LocalDataStore(testDataStore)

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun test_saveStringData() = testScope.runTest {
        localDataStore.saveStringData("string", "123")
        assertEquals("123", localDataStore.getStringData("string").firstOrNull())
    }

    @Test
    fun test_saveIntData() = testScope.runTest {
        localDataStore.saveIntData("int", 222)
        assertEquals(222, localDataStore.getIntData("int").firstOrNull())
    }

    @Test
    fun test_saveBooleanData() = testScope.runTest {
        localDataStore.saveBooleanData("boolean", true)
        assertEquals(true, localDataStore.getBooleanData("boolean").firstOrNull())
    }

    @Test
    fun test_saveListData() = testScope.runTest {
        val testData = listOf("1", "2", "3", null)
        localDataStore.saveList("list", testData)
        assertEquals(testData, localDataStore.getList<String?>("list").firstOrNull())
    }
}