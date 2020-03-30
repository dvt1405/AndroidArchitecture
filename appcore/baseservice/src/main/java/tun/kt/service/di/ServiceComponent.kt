package tun.kt.service.di

import dagger.BindsInstance
import dagger.Component
import tun.kt.data.di.DataComponent
import tun.kt.service.service.AuthFirebaseService
import tun.kt.service.service.AuthFirebaseServiceImpl

@ServiceScope
@Component(modules = [ServiceModule::class], dependencies = [DataComponent::class])
interface ServiceComponent {

    val authFirebaseService: AuthFirebaseService
    @Component.Builder
    interface Builder {
        fun build(): ServiceComponent
        fun dataComponent(dataComponent: DataComponent): Builder
    }
}