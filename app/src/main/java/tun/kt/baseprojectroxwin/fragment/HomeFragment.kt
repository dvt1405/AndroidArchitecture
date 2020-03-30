package tun.kt.baseprojectroxwin.fragment

import android.view.View
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragment_main.view.*
import tun.kt.baseprojectroxwin.MainActivity
import tun.kt.baseprojectroxwin.R
import tun.kt.baseui.BaseFragment
import tun.kt.data.DataState
import tun.kt.data.model.Marker
import tun.kt.service.Log
import tun.kt.usecase.repository.ImageRepository
import javax.inject.Inject


class HomeFragment : BaseFragment(R.layout.fragment_main) {

    @Inject
    lateinit var viewModel: HomeViewModel

    @Inject
    lateinit var imageRepository: ImageRepository

    override fun initView(view: View) {
        (activity as MainActivity).appComponent.inject(this)
    }

    override fun initAction(view: View) {
        view.launchLogin.setOnClickListener { launchLogin: View ->
            viewModel.logout().observe(this, Observer {
                when (it) {
                    is DataState.Success -> {
                        launchLogin.findNavController()
                            .navigate(R.id.action_mainActivity_to_loginFragment22)
                    }
                    is DataState.Failure -> {
                        Log.error(it.throwable)
                    }
                }
            })
        }
        view.launchDashboard.setOnClickListener {
            it.findNavController().navigate(R.id.action_mainActivity_to_dashboardFragment2)
        }
        view.launchMap.setOnClickListener {
            it.findNavController().navigate(R.id.action_mainActivity_to_fragmentDisplayMap)
        }
//        viewModel.useCase.getImage(Marker(null, "11", "11", null, null, null))
//            .observe(this, Observer {
//                when(it) {
//                    is DataState.Success -> {
//                        Log.error("Success")
//                    }
//                    is DataState.Failure -> {
//                        Log.error(it.throwable)
//                    }
//
//                }
//            })
    }
}