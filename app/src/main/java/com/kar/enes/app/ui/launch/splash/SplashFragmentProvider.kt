package com.kar.enes.app.ui.launch.splash

import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by M.Enes on 10/21/2020.
 */
@Module
abstract class SplashFragmentProvider {

    @ContributesAndroidInjector
    abstract fun provideSplashFragmentFactory():SplashFragment
}