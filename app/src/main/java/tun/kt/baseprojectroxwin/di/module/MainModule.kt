package tun.kt.baseprojectroxwin.di.module

import dagger.Module
import dagger.Provides
import tun.kt.baseprojectroxwin.fragment.HomeFragment
import javax.inject.Singleton

@Module
abstract class MainModule() {
    @Provides
    @Singleton
    fun providesHomeFragment() = HomeFragment()
}