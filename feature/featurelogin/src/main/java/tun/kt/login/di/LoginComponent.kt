package tun.kt.login.di

import dagger.Component
import tun.kt.data.di.DataComponent
import tun.kt.login.LoginFragment
import tun.kt.service.di.ServiceComponent
import tun.kt.usecase.di.UseCaseComponent

@Component(
    modules = [LoginModule::class],
    dependencies = [DataComponent::class, UseCaseComponent::class, ServiceComponent::class]
)
@LoginScope
interface LoginComponent {
    fun inject(loginFragment: LoginFragment)

    @Component.Builder
    interface Builder {
        fun build(): LoginComponent
        fun dataComponent(dataComponent: DataComponent): Builder
        fun useCaseComponent(useCaseComponent: UseCaseComponent): Builder
        fun serviceComponent(serviceComponent: ServiceComponent): Builder
        fun loginModule(loginModule: LoginModule): Builder
    }
}