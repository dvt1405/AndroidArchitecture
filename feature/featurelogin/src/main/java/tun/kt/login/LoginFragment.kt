package tun.kt.login

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragment_login.view.*
import tun.kt.baseui.BaseFragment
import tun.kt.data.DataState
import tun.kt.login.di.LoginComponent
import tun.kt.service.Log
import tun.kt.service.model.User
import javax.inject.Inject

class LoginFragment : BaseFragment(R.layout.fragment_login) {

    @Inject
    lateinit var loginViewModel: LoginViewModel
    var liveDataUser = MutableLiveData<User>()
    override fun initView(view: View) {
        loginComponent.inject(this)
    }

    override fun initAction(view: View) {
        liveDataUser.observe(this, Observer {

        })
        loginViewModel.getCurrentUser().observe(this, androidx.lifecycle.Observer {
            when (it) {
                is DataState.Success -> {
                    loginNavigator?.navigateToMain(view.findNavController(), true)
                }
                is DataState.Failure -> {
                    Log.error(it.throwable)
                }
            }
        })

        view.btnLogin.setOnClickListener {
            liveDataUser.postValue(
                User(
                    view.loginEmail.text.toString(),
                    view.loginPassword.text.toString(),
                    "ok"
                )
            )
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        loginNavigator = null
    }

    companion object {
        var loginNavigator: LoginNavigator? = null
        lateinit var loginComponent: LoginComponent
    }
}