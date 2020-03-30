package tun.kt.service.di

import javax.inject.Scope
import javax.inject.Singleton

@Scope
@Singleton
@MustBeDocumented
@Retention(value = AnnotationRetention.RUNTIME)
annotation class ServiceScope {
}