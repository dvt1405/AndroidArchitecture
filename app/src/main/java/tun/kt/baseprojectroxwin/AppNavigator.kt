package tun.kt.baseprojectroxwin

import android.view.View
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.findNavController
import tun.kt.dashboard.PaintFragmentDirections
import tun.kt.dashboard.PaintNavigator
import tun.kt.login.LoginFragmentDirections
import tun.kt.login.LoginNavigator
import java.lang.Exception

class AppNavigator : PaintNavigator, LoginNavigator {
    private var navController: NavController? = null
    override fun navigateToDisplayImage(view: View, captureContent: ByteArray?) {
        try {
            val action = PaintFragmentDirections.actionDashboardFragment2ToDisplayImageFragment(String(captureContent!!))
            view.findNavController().navigate(action)
        } catch (e: Exception) {

        }
    }

    override fun navigateToMap(view: View) {
        navController?.navigate(R.id.action_dashboardFragment2_to_loginFragment2)
    }

    fun bind(navController: NavController) {
        this.navController = navController
    }

    fun unbind() {
        navController = null
    }

    override fun navigateToMain(navController: NavController, isAuth: Boolean) {
        val navOptions = NavOptions.Builder()
        navOptions.setPopUpTo(R.id.loginFragment2, true)
        val action = LoginFragmentDirections.actionLoginFragment2ToMainActivity(isAuth)
        navController.navigate(action, navOptions.build())
    }

    override fun navigateToSignUp(navController: NavController) {

    }
}