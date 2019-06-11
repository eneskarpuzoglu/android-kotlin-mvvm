package com.kar.enes.app.di

import com.kar.enes.app.ui.login.LoginActivity
import com.kar.enes.app.ui.splash.SplashActivity
import com.kar.enes.app.ui.splash.SplashActivityModule
import com.kar.enes.app.ui.login.LoginActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by M.Enes on 5/8/2019
 */
@Module
abstract class BuilderModule {

    @ContributesAndroidInjector(modules = [LoginActivityModule::class])
    internal abstract fun bindLoginActivity(): LoginActivity


    @ContributesAndroidInjector(modules = [SplashActivityModule::class])
    internal abstract fun bindSplashActivity(): SplashActivity
}