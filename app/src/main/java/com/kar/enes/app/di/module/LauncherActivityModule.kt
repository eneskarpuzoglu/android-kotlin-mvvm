package com.kar.enes.app.di.module

import com.kar.enes.app.ui.launch.login.LoginFragment
import com.kar.enes.app.ui.launch.splash.SplashFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by M.Enes on 24.04.2019
 */
@Module
abstract class LauncherActivityModule {

    @ContributesAndroidInjector
    abstract fun provideSplashFragmentFactory(): SplashFragment

    @ContributesAndroidInjector
    abstract fun provideLoginFragmentFactory(): LoginFragment

}