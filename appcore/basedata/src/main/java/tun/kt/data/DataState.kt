package tun.kt.data

sealed class DataState<T> {
    data class Success<T>(val value: T) : DataState<T>()
    data class Failure<T>(val throwable: Throwable) : DataState<T>()
}