package tun.kt.service.service

import androidx.lifecycle.LiveData
import com.google.firebase.auth.FirebaseUser
import tun.kt.data.DataState
import tun.kt.service.model.User

interface AuthFirebaseService {
    fun login(user: User): LiveData<DataState<User?>>
    fun signUp(user: User): LiveData<DataState<User?>>
    fun checkSession(): Boolean
    fun getCurrentUser() :LiveData<DataState<User>>
    fun logout(): LiveData<DataState<Boolean>>
}