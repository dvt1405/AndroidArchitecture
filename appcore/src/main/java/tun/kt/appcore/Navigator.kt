package tun.kt.navigator

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.View
import androidx.core.app.ActivityOptionsCompat
import androidx.core.util.Pair

object Navigator {
    /**
     * @author: kun.tun
     * */
    private const val LOGIN_ACTIVITY_PACKAGE_NAME = "tun.kt.login.Login"
    private const val ACTION_START_LOGIN = "tun.kt.login.action.ACTION_START"
    private const val DASH_BOARD_ACTIVITY_PACKAGE_NAME = "tun.kt.dashboard.DashboardActivity"
    private const val ACTION_START_DASH_BOARD = "tun.kt.dashboard.action.ACTION_START"

    fun getIntentStartDashboardActivity(context: Context): Intent {
        return Intent(ACTION_START_DASH_BOARD)
            .setPackage(context.packageName)
    }

    fun getIntentStartDashboardActivity(context: Activity, view: View): Intent {
        return Intent(ACTION_START_DASH_BOARD)
            .setPackage(context.packageName)
    }

    fun getIntentStartLoginActivity(context: Context): Intent {
        return Intent(ACTION_START_LOGIN).setAction(ACTION_START_LOGIN)
            .setPackage(context.packageName)
    }
}
