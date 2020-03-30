package tun.kt.service.service

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import tun.kt.data.DataState
import tun.kt.data.Mapper
import tun.kt.service.model.MapperUser
import tun.kt.service.model.User
import java.lang.Exception
import javax.inject.Inject

class AuthFirebaseServiceImpl @Inject constructor(private val firebaseAuth: FirebaseAuth) :
    AuthFirebaseService {
    private val liveData = MutableLiveData<DataState<User?>>()

    @Throws()
    override fun login(user: User): LiveData<DataState<User?>> {
        try {
            firebaseAuth.signInWithEmailAndPassword(user.email!!, user.password!!)
                .addOnCompleteListener {
                    if (it.isSuccessful) {
                        liveData.postValue(
                            DataState.Success(
                                MapperUser(firebaseAuth).mapFrom(
                                    firebaseAuth.currentUser!!
                                )
                            )
                        )
                    } else {
                        liveData.postValue(DataState.Failure(it.exception!!))
                    }
                }

        } catch (e: Exception) {
            liveData.postValue(DataState.Failure(e))
        }
        return liveData
    }

    override fun signUp(user: User): LiveData<DataState<User?>> {
        val liveData = MutableLiveData<DataState<User?>>()
        try {
            firebaseAuth.createUserWithEmailAndPassword(user.email!!, user.password!!)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        liveData.postValue(
                            DataState.Success(
                                MapperUser(firebaseAuth).mapFrom(
                                    firebaseAuth.currentUser!!
                                )
                            )
                        )
                    } else {
                        liveData.postValue(DataState.Failure(Throwable("Sign up fail")))
                    }
                }
        } catch (e: Exception) {
            liveData.postValue(DataState.Failure(NullPointerException("Email or password null")))
        }

        return liveData
    }

    override fun checkSession(): Boolean {
        return true
    }

    override fun getCurrentUser(): LiveData<DataState<User>> =
        try {
            MutableLiveData(DataState.Success(MapperUser(firebaseAuth).mapFrom(firebaseAuth.currentUser)))
        } catch (e: Exception) {
            MutableLiveData(DataState.Failure(e))
        }

    override fun logout(): LiveData<DataState<Boolean>> =
        try {
            FirebaseAuth.getInstance().signOut()
            MutableLiveData(DataState.Success(true))

        } catch (e: Exception) {
            MutableLiveData(DataState.Failure(e))
        }
}