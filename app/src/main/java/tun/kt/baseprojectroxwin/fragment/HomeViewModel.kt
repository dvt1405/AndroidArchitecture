package tun.kt.baseprojectroxwin.fragment

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import tun.kt.baseprojectroxwin.MyApplication
import tun.kt.data.model.Image
import tun.kt.usecase.usecase.UseCase
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    application: Application,
    val useCase: HomeFragmentInteractor
) :
    AndroidViewModel(application) {

    fun logout() = useCase.authFirebaseService.logout()

    class Factory @Inject constructor(context: Context, val useCase: HomeFragmentInteractor) :
        ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return HomeViewModel(MyApplication(), useCase) as T
        }
    }
}