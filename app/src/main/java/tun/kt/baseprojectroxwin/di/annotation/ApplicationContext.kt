package tun.kt.baseprojectroxwin.di.annotation

import javax.inject.Scope
import javax.inject.Singleton

@Singleton
@Scope
@Retention(value = AnnotationRetention.RUNTIME)
annotation class ApplicationContext {
}