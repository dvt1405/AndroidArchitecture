package tun.kt.data.local.storage

import android.content.SharedPreferences
import tun.kt.data.DataState
import tun.kt.data.datasource.SharePreferencesDataSource
import java.lang.Exception
import javax.inject.Inject

class SharedPreferencesDataSourceImpl @Inject constructor(private val sharedPreferences: SharedPreferences?) :
    SharePreferencesDataSource {
    override fun saveData(dataKey: String, dataValue: Any): DataState<Boolean> {
        return try {
            when (dataValue) {
                is String -> {
                    sharedPreferences?.edit()?.putString(dataKey, dataValue)?.apply()
                }
                is Int -> {
                    sharedPreferences?.edit()?.putInt(dataKey, dataValue)?.apply()
                }
                is Boolean -> {
                    sharedPreferences?.edit()?.putBoolean(dataKey, dataValue)?.apply()
                }
                is Float -> {
                    sharedPreferences?.edit()?.putFloat(dataKey, dataValue)?.apply()
                }
                is Long -> {
                    sharedPreferences?.edit()?.putLong(dataKey, dataValue)?.apply()
                }
                else -> {
                    throw Exception("Share preferences not support this type ${dataValue.javaClass.name}")
                }
            }
            DataState.Success(true)
        } catch (e: Exception) {
            DataState.Failure(e)
        }
    }

    override fun getStringData(dataKey: String, defaultValue: String?): DataState<String?> {
        return try {
            val data: String? = sharedPreferences?.getString(dataKey, defaultValue)
            DataState.Success(data)
        } catch (e: Exception) {
            DataState.Failure(e)
        }
    }

    override fun getNumberData(dataKey: String, defaultValue: Number?): DataState<Number?> {
        return try {
            val data: Number? = sharedPreferences?.getInt(dataKey, defaultValue?.toInt() ?: error(0))
            DataState.Success(data)
        } catch (e: Exception) {
            DataState.Failure(e)
        }
    }

    override fun getBooleanData(dataKey: String, defaultValue: Boolean?): DataState<Boolean?> {
        return try {
            val data: Boolean? = sharedPreferences?.getBoolean(dataKey, defaultValue!!)
            DataState.Success(data)
        } catch (e: Exception) {
            DataState.Failure(e)
        }
    }

    override fun clearData(): DataState<Boolean> {
        return try {
            sharedPreferences?.edit()?.clear()
            DataState.Success(true)
        } catch (e: Exception) {
            DataState.Failure(e)
        }
    }
}