package tun.kt.login.di

import android.app.Application
import dagger.Module
import dagger.Provides
import tun.kt.login.LoginInteractors
import tun.kt.login.LoginViewModel
import tun.kt.usecase.usecase.UseCase

@Module
class LoginModule(val application: Application) {
    @Provides
    @LoginScope
    fun providesLoginViewModel(useCase: LoginInteractors) =
        LoginViewModel.Factory(application, useCase)

    @Provides
    @LoginScope
    fun providesApplication() = application
}