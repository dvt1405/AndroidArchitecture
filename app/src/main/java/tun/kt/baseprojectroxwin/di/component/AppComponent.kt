package tun.kt.baseprojectroxwin.di.component

import android.app.Application
import androidx.fragment.app.FragmentActivity
import dagger.BindsInstance
import dagger.Component
import org.jetbrains.annotations.NotNull
import tun.kt.baseprojectroxwin.MainActivity
import tun.kt.baseprojectroxwin.di.annotation.ApplicationContext
import tun.kt.baseprojectroxwin.di.module.AppModule
import tun.kt.baseprojectroxwin.fragment.HomeFragment
import tun.kt.data.di.DataComponent
import tun.kt.data.di.DataSourceModule
import tun.kt.data.di.NetworkModule
import tun.kt.data.di.LocalModule
import tun.kt.login.di.LoginComponent
import tun.kt.service.di.ServiceComponent
import tun.kt.usecase.di.RepositoryModule
import tun.kt.usecase.di.UseCaseComponent
import tun.kt.usecase.di.UseCaseModule
import javax.inject.Singleton

@ApplicationContext
@Component(
    modules = [AppModule::class],
    dependencies = [DataComponent::class, UseCaseComponent::class, ServiceComponent::class, LoginComponent::class]
)
interface AppComponent {
    fun inject(activity: MainActivity)
    fun inject(activity: HomeFragment)

    @Component.Builder
    interface Builder {
        fun build(): AppComponent

        //        fun applicationContext(@NotNull application: Application): Builder
        fun appModule(appModule: AppModule): Builder
        fun dataComponent(dataComponent: DataComponent): Builder
        fun useCaseComponent(useCaseComponent: UseCaseComponent): Builder
        fun serviceComponent(serviceComponent: ServiceComponent): Builder
        fun loginComponent(loginComponent: LoginComponent): Builder
    }
}