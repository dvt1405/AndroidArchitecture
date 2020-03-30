package tun.kt.data.di

import java.lang.annotation.RetentionPolicy
import javax.inject.Scope
import javax.inject.Singleton

@Scope
@MustBeDocumented
@Retention(value = AnnotationRetention.RUNTIME)
annotation class DataScope {
}