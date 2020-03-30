package tun.kt.baseprojectroxwin.di.module

import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import dagger.Module
import dagger.Provides
import tun.kt.baseprojectroxwin.di.annotation.ApplicationContext
import tun.kt.baseprojectroxwin.fragment.HomeFragmentInteractor
import tun.kt.baseprojectroxwin.fragment.HomeViewModel
import tun.kt.login.di.DaggerLoginComponent
import tun.kt.login.di.LoginModule
import tun.kt.usecase.repository.ImageRepositoryImpl
import tun.kt.usecase.usecase.GetImage
import tun.kt.usecase.usecase.UseCase
import javax.inject.Singleton

@Module
class AppModule(val context: Context, val viewModelStoreOwner: ViewModelStoreOwner) {

    @Provides
    @ApplicationContext
    fun context() = context

    @Provides
    @ApplicationContext
    fun provideHomeViewModel(context: Context, useCase: HomeFragmentInteractor) =
        ViewModelProvider(viewModelStoreOwner, HomeViewModel.Factory(context, useCase)).get(
            HomeViewModel::class.java
        )

}