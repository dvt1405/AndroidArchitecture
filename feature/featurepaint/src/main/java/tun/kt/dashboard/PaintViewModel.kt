package tun.kt.dashboard

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

class PaintViewModel(application: Application, useCase: PaintUseCase) :
    AndroidViewModel(application) {

    class Factory @Inject constructor(val application: Application, val useCase: PaintUseCase) :
        ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return PaintViewModel(application, useCase) as T
        }
    }

    fun savePicture(byteArray: ByteArray?) {

    }
}