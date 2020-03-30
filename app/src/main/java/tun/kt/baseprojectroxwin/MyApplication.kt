package tun.kt.baseprojectroxwin

import android.app.Application
import androidx.navigation.Navigator
import me.vponomarenko.injectionmanager.IHasComponent
import me.vponomarenko.injectionmanager.x.XInjectionManager
import tun.kt.baseprojectroxwin.di.component.AppComponent
import tun.kt.baseprojectroxwin.di.component.DaggerAppComponent
import tun.kt.baseprojectroxwin.di.module.AppModule
import tun.kt.data.di.DaggerDataComponent
import tun.kt.data.di.DataSourceModule
import tun.kt.data.di.LocalModule
import tun.kt.usecase.di.DaggerUseCaseComponent

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        XInjectionManager.bindComponentToCustomLifecycle(object : IHasComponent<AppNavigator> {
            override fun getComponent(): AppNavigator = AppNavigator()
        })
        XInjectionManager.bindComponentToCustomLifecycle(object : IHasComponent<MyApplication> {
            override fun getComponent(): MyApplication = this@MyApplication
        })
    }
}