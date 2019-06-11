package com.kar.enes.app.data.local.prefs

import com.kar.enes.app.data.DataManager
import com.kar.enes.app.data.model.UserModel

/**
 * Created by M.Enes on 5/9/2019
 */
interface PreferencesHelper {

    fun getUser(): UserModel?

    fun setUser(model: UserModel?)


    fun getCurrentUserLoggedMode(): Int?

    fun setCurrentUserLoggedMode(mode: DataManager.LoggedMode?)
}