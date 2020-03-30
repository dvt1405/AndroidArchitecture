package tun.kt.service

import android.util.Log

@Suppress("unused")
object Log {
    private const val ERROR = " Error"
    private const val DEBUG = "Debug"
    private const val INFORMATION = "Info"
    fun error(message: String) {
        error(ERROR, message, null)
    }

    fun error(throwable: Throwable) {
        error(ERROR, throwable.message, throwable)
    }

    fun error(tag: String, message: String?, throwable: Throwable?) {
        Log.e(tag, message, throwable)
    }

    fun debug(message: String) {
        debug(DEBUG, message)
    }

    fun debug(tag: String, message: String) {
        Log.d(tag, message)
    }

    fun info(message: String) {
        info(INFORMATION, message)
    }

    fun info(tag: String, message: String) {
        Log.i(tag, message)
    }
}