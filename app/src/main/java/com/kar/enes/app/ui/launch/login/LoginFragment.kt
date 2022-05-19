package com.kar.enes.app.ui.launch.login

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ValueAnimator
import android.app.Activity
import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.ViewModelProvider
import com.kar.enes.app.BR
import com.kar.enes.app.R
import com.kar.enes.app.databinding.FragmentLoginBinding
import com.kar.enes.app.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_login.*
import javax.inject.Inject

/**
 * Created by M.Enes on 10/21/2020.
 */
class LoginFragment: BaseFragment<FragmentLoginBinding, LoginViewModel>(),LoginNavigator {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    lateinit var loginViewModel: LoginViewModel

    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_login
    }

    override fun getViewModel(): LoginViewModel {
        loginViewModel = ViewModelProvider(this, viewModelFactory)[LoginViewModel::class.java]
        return  loginViewModel
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loginViewModel.setNavigator(this)
    }


    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        if (loginViewModel.dataManager.isDarkTheme()){
            lawTheme.progress = 0.5f
        }else{
            lawTheme.progress = 0f
        }
    }

    override fun activity(): Activity {
        return requireActivity()
    }

    override fun context(): Context {
        return requireContext()
    }


    override fun setDay() {
        val animator = ValueAnimator.ofFloat(0.5f, 1f).setDuration(700)
        animator.addUpdateListener {
            lawTheme.progress = it.animatedValue as Float
        }
        animator.addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator) {
                // done
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        })
        animator.start()
    }

    override fun setNight() {
        val animator = ValueAnimator.ofFloat(0f, 0.5f).setDuration(700)
        animator.addUpdateListener {
            lawTheme.progress = it.animatedValue as Float
        }
        animator.addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator) {
                // done
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            }
        })
        animator.start()
    }

}