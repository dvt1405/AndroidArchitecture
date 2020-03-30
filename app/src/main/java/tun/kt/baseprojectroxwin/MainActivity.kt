package tun.kt.baseprojectroxwin

import android.os.Bundle
import android.util.Log
import android.widget.FrameLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import me.vponomarenko.injectionmanager.x.XInjectionManager
import tun.kt.apilib.apihistory.BaseActivity
import tun.kt.baseprojectroxwin.R.*
import tun.kt.baseprojectroxwin.di.component.AppComponent
import tun.kt.baseprojectroxwin.di.component.DaggerAppComponent
import tun.kt.baseprojectroxwin.di.module.AppModule
import tun.kt.baseprojectroxwin.fragment.HomeFragment
import tun.kt.data.datasource.MarkerDataSource
import tun.kt.data.datasource.SharePreferencesDataSource
import tun.kt.data.di.DaggerDataComponent
import tun.kt.data.di.DataSourceModule
import tun.kt.data.di.LocalModule
import tun.kt.data.local.dao.ImageDAO
import tun.kt.data.model.Marker
import tun.kt.data.network.API
import tun.kt.displaymap.FragmentDisplayMap
import tun.kt.login.LoginFragment
import tun.kt.login.di.DaggerLoginComponent
import tun.kt.login.di.LoginModule
import tun.kt.service.di.DaggerServiceComponent
import tun.kt.service.di.ServiceComponent
import tun.kt.usecase.di.DaggerUseCaseComponent
import tun.kt.usecase.repository.ImageRepository
import javax.inject.Inject

class MainActivity : BaseActivity() {
    private val dataComponent by lazy {
        DaggerDataComponent.builder()
            .roomDBModule(LocalModule(baseContext))
            .build()
    }
    private val usecaseComponent by lazy {
        DaggerUseCaseComponent.builder()
            .dataComponent(dataComponent)
            .build()
    }
    private val serviceComponent by lazy {
        DaggerServiceComponent.builder()
            .dataComponent(dataComponent)
            .build()
    }
    private val loginComponent by lazy {
        DaggerLoginComponent.builder()
            .loginModule(LoginModule(application))
            .dataComponent(dataComponent)
            .useCaseComponent(usecaseComponent)
            .serviceComponent(serviceComponent)
            .build()
    }
    val appComponent by lazy {
        DaggerAppComponent.builder()
            .appModule(AppModule(application, this))
            .dataComponent(dataComponent)
            .useCaseComponent(usecaseComponent)
            .serviceComponent(serviceComponent)
            .loginComponent(loginComponent)
            .build()
    }
    private lateinit var navController: NavController
    private lateinit var mainLayout: FrameLayout
    private val navigator: AppNavigator by lazy {
        XInjectionManager.findComponent<AppNavigator>()
    }

    @Inject
    lateinit var sharedPreferencesDataSource: SharePreferencesDataSource

    @Inject
    lateinit var api: API

    @Inject
    lateinit var imageDAO: ImageDAO

    @Inject
    lateinit var imageRepository: ImageRepository

    @Inject
    lateinit var markerDataSource: MarkerDataSource
    lateinit var homeFragment: HomeFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)
        appComponent.inject(this)
        navController = findNavController(R.id.hostFragment)
        LoginFragment.loginComponent = loginComponent
        LoginFragment.loginNavigator = navigator
        FragmentDisplayMap.usecaseComponent = usecaseComponent
    }

    override fun onResume() {
        super.onResume()
        navigator.bind(findNavController(R.id.hostFragment))
        LoginFragment.loginNavigator = navigator
    }

    override fun onPause() {
        super.onPause()
        navigator.bind(findNavController(R.id.hostFragment))
        LoginFragment.loginNavigator = null
    }

    override fun onDestroy() {
        super.onDestroy()
        FragmentDisplayMap.usecaseComponent=null

    }
}