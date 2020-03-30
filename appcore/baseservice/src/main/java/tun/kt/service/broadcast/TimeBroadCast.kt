package tun.kt.service.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class TimeBroadCast(private val callback: TimeTick?) : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        intent?.action?.let {
            when (it) {
                Intent.ACTION_TIME_TICK -> {
                    callback?.onMinuteChange()
                }
                Intent.ACTION_TIME_CHANGED -> {
                    callback?.onHourChange()
                }
                else -> {
                }
            }
        }
    }

    interface TimeTick {
        fun onMinuteChange()
        fun onHourChange()
    }

}