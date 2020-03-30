package tun.kt.data.datasource

import tun.kt.data.DataState

interface SharePreferencesDataSource {
    fun saveData(dataKey: String, dataValue: Any): DataState<Boolean>
    fun getStringData(dataKey: String, defaultValue: String?): DataState<String?>
    fun getNumberData(dataKey: String, defaultValue: Number?): DataState<Number?>
    fun getBooleanData(dataKey: String, defaultValue: Boolean?): DataState<Boolean?>
    fun clearData(): DataState<Boolean>
}