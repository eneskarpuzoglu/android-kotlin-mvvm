package com.kar.enes.app.di

import com.kar.enes.app.ui.launch.LauncherActivity
import com.kar.enes.app.ui.launch.LauncherActivityModule
import com.kar.enes.app.ui.launch.login.LoginFragmentProvider
import com.kar.enes.app.ui.launch.splash.SplashFragmentProvider
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by M.Enes on 5/8/2019
 */
@Module
abstract class BuilderModule {

    @ContributesAndroidInjector(modules = [LauncherActivityModule::class,SplashFragmentProvider::class,LoginFragmentProvider::class])
    internal abstract fun bindLauncherActivity(): LauncherActivity
}