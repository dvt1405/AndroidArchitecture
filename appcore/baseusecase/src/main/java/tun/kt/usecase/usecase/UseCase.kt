package tun.kt.usecase.usecase

import androidx.lifecycle.LiveData

interface UseCase<T> {
    fun execute(): LiveData<T>
}