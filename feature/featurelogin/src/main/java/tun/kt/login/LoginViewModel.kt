package tun.kt.login

import android.app.Application
import android.content.Context
import androidx.lifecycle.*
import tun.kt.data.DataState
import tun.kt.service.Log
import tun.kt.service.model.User
import javax.inject.Inject

class LoginViewModel @Inject constructor(application: Application, val useCase: LoginInteractors) :
    AndroidViewModel(application) {

    class Factory @Inject constructor(val application: Application, val useCase: LoginInteractors) :
        ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return LoginViewModel(application, useCase) as T
        }
    }
    fun login(user: User) = useCase.firebaseService.login(user)
    fun getCurrentUser() = useCase.firebaseService.getCurrentUser()
}