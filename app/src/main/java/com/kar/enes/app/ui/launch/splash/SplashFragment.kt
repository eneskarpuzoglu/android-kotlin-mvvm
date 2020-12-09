package com.kar.enes.app.ui.launch.splash

import android.content.pm.PackageManager
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import com.kar.enes.app.BR
import com.kar.enes.app.R
import com.kar.enes.app.databinding.FragmentSplashBinding
import com.kar.enes.app.ui.base.BaseFragment
import com.kar.enes.app.utils.AppConstants
import javax.inject.Inject

/**
 * Created by M.Enes on 10/21/2020.
 */
class SplashFragment: BaseFragment<FragmentSplashBinding, SplashViewModel>(),SplashNavigator {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    lateinit var splashViewModel: SplashViewModel

    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_splash
    }

    override fun getViewModel(): SplashViewModel {
        splashViewModel = ViewModelProviders.of(this, viewModelFactory).get(SplashViewModel::class.java)
        return splashViewModel
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        splashViewModel.setNavigator(this)
        start()
    }

    private fun start() {
        Handler(Looper.getMainLooper()).postDelayed({
            // Login ekranini ac
            openLogin()
        }, AppConstants.SPLASH_TIME)
    }

    private fun openLogin(){
        Navigation.findNavController(requireActivity(), R.id.launch_fragment).navigate(SplashFragmentDirections.actionSplashToLogin())
    }
}