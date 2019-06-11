package com.kar.enes.app.di

import android.content.Context
import com.kar.enes.app.App
import com.kar.enes.app.data.AppDataManager
import com.kar.enes.app.data.DataManager
import com.kar.enes.app.data.local.prefs.AppPreferencesHelper
import com.kar.enes.app.data.local.prefs.PreferencesHelper
import com.kar.enes.app.di.annotations.PreferenceInfo
import com.kar.enes.app.utils.AppConstants
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by M.Enes on 5/8/2019
 */
@Module
class AppContextModule {

    @Provides
    internal fun provideContext(app: App): Context {
        return app.applicationContext
    }

    @Provides
    @Singleton
    internal fun providePreferencesHelper(appPreferencesHelper: AppPreferencesHelper): PreferencesHelper {
        return appPreferencesHelper
    }

    @Provides
    @Singleton
    internal fun provideDataManager(appDataManager: AppDataManager): DataManager {
        return appDataManager
    }

    @Provides
    @PreferenceInfo
    internal fun providePreferenceName(): String {
        return AppConstants.PREFERENCES_NAME
    }
}