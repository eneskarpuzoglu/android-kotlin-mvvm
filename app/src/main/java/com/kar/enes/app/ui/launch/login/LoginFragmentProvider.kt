package com.kar.enes.app.ui.launch.login

import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by M.Enes on 10/21/2020.
 */
@Module
abstract class LoginFragmentProvider {

    @ContributesAndroidInjector
    abstract fun provideLoginFragmentFactory(): LoginFragment
}