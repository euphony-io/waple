package com.euphony.waple.data

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.lang.reflect.ParameterizedType

class LocalDataStore(
    val dataStore: DataStore<Preferences>
) {

    val moshi: Moshi = Moshi.Builder().build()

    fun <T> toList(type: ParameterizedType, json: String) =
        moshi.adapter<List<T>>(type).fromJson(json) ?: emptyList()

    inline fun <reified T> getList(key: Preferences.Key<String>): Flow<List<T>> =
        dataStore.data.map {
            val json = it[key] ?: ""
            try {
                toList(
                    Types.newParameterizedType(List::class.java, T::class.java),
                    json
                )
            } catch (e: Exception) {
                emptyList()
            }
        }

    fun getIntData(key: String) = dataStore.data
        .map { preferences ->
            preferences[intPreferencesKey(key)] ?: 0
        }

    fun getStringData(key: String) = dataStore.data
        .map { preferences ->
            preferences[stringPreferencesKey(key)] ?: ""
        }

    fun getBooleanData(key: String) = dataStore.data
        .map { preferences ->
            preferences[booleanPreferencesKey(key)] ?: false
        }

    suspend inline fun <reified T> saveList(
        key: String,
        data: List<T>,
    ) {
        val type = Types.newParameterizedType(List::class.java, T::class.java)
        dataStore.edit {
            it[stringPreferencesKey(key)] = moshi.adapter<List<T>>(type).toJson(data)
        }
    }

    suspend fun saveIntData(key: String, value: Int?) {
        dataStore.edit { store ->
            store[intPreferencesKey(key)] = value ?: 0
        }
    }

    suspend fun saveStringData(key: String, value: String?) {
        dataStore.edit { store ->
            store[stringPreferencesKey(key)] = value ?: ""
        }
    }

    suspend fun saveBooleanData(key: String, value: Boolean) {
        dataStore.edit { store ->
            store[booleanPreferencesKey(key)] = value
        }
    }
}