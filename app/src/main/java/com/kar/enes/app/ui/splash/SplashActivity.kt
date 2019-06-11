package com.kar.enes.app.ui.splash

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.kar.enes.app.BR
import com.kar.enes.app.R
import com.kar.enes.app.databinding.ActivitySplashBinding
import com.kar.enes.app.ui.login.LoginActivity
import com.kar.enes.app.ui.base.BaseActivity
import javax.inject.Inject


class SplashActivity  : BaseActivity<ActivitySplashBinding, SplashViewModel>(),SplashNavigator {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    lateinit var splashViewModel: SplashViewModel

    override fun getLayoutId(): Int {
        return R.layout.activity_splash
    }

    override fun getBindingVariable(): Int {
            return BR.viewModel
    }

    override fun getViewModel(): SplashViewModel {
        splashViewModel = ViewModelProviders.of(this, viewModelFactory).get(SplashViewModel::class.java)
        return splashViewModel
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        splashViewModel.setNavigator(this)
        splashViewModel.start()

    }

    override fun openLoginActivity(){
        val intent = Intent(this, LoginActivity::class.java)
        //intent.flags = Intent.FLAG_ACTIVITY_NO_ANIMATION
        startActivity(intent)
        finish()
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
    }

    override fun openMainActivity(){
        val intent = Intent(this, LoginActivity::class.java)
        //intent.flags = Intent.FLAG_ACTIVITY_NO_ANIMATION
        startActivity(intent)
        finish()
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
    }
}
