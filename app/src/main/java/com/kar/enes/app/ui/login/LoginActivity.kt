package com.kar.enes.app.ui.login

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.kar.enes.app.BR
import com.kar.enes.app.R
import com.kar.enes.app.databinding.ActivityLoginBinding
import com.kar.enes.app.ui.base.BaseActivity
import timber.log.Timber
import javax.inject.Inject

class LoginActivity : BaseActivity<ActivityLoginBinding, LoginViewModel>(),LoginNavigator {

    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory
    lateinit var loginViewModel: LoginViewModel

    override fun getLayoutId(): Int {
        return R.layout.activity_login
    }

    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    override fun getViewModel(): LoginViewModel {
        loginViewModel = ViewModelProviders.of(this, viewModelFactory).get(LoginViewModel::class.java)
        return loginViewModel
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loginViewModel.setNavigator(this)

        if (loginViewModel.dataManager.getUser() != null) {
            Timber.i("AAAAa")
            Timber.i(loginViewModel.dataManager.getUser()!!.email)
        }

    }
}
