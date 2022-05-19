package com.kar.enes.app.di

import com.kar.enes.app.App
import com.kar.enes.app.di.module.AppContextModule
import com.kar.enes.app.di.module.BuilderModule
import com.kar.enes.app.di.module.NetworkModule
import com.kar.enes.app.di.module.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * Created by M.Enes on 5/8/2019
 */
@Singleton
@Component(modules = [AndroidSupportInjectionModule::class, NetworkModule::class, AppContextModule::class, BuilderModule::class, ViewModelModule::class])
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app: App): Builder

        fun build(): AppComponent
    }

    fun inject(app: App)
}