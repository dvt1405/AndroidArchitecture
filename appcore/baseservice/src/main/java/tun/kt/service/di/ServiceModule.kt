package tun.kt.service.di

import com.google.firebase.auth.FirebaseAuth
import dagger.Module
import dagger.Provides
import org.intellij.lang.annotations.PrintFormat
import tun.kt.service.service.AuthFirebaseService
import tun.kt.service.service.AuthFirebaseServiceImpl

@Module
class ServiceModule {

    @Provides
    @ServiceScope
    fun providesFirebaseAuth() = FirebaseAuth.getInstance()

    @Provides
    @ServiceScope
    fun providesAuthService(firebaseAuth: FirebaseAuth): AuthFirebaseService =
        AuthFirebaseServiceImpl(firebaseAuth)
}