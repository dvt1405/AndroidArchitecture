package tun.kt.displaymap.di

import dagger.Component
import tun.kt.data.di.DataComponent
import tun.kt.displaymap.FragmentDisplayMap
import tun.kt.usecase.di.UseCaseComponent

@MapScope
@Component(modules = [], dependencies = [UseCaseComponent::class])
interface MapComponent {
    fun inject(fragmentDisplayMap: FragmentDisplayMap)
    @Component.Builder
    interface Builder {
        fun build(): MapComponent
        fun useCaseComponent(useCaseComponent: UseCaseComponent): Builder
    }
}