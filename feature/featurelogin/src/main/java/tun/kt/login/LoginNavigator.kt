package tun.kt.login

import android.app.Activity
import android.os.Bundle
import androidx.navigation.NavController

interface LoginNavigator {
    fun navigateToMain(navController: NavController,isAuth: Boolean)
    fun navigateToSignUp(navController: NavController)
}