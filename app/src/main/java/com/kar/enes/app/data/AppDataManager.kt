package com.kar.enes.app.data

import com.kar.enes.app.data.local.prefs.PreferencesHelper
import com.kar.enes.app.data.model.request.LoginReq
import com.kar.enes.app.data.remote.ApiHelper
import com.kar.enes.app.data.model.UserModel
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by M.Enes on 24.04.2019
 */
@Singleton
class AppDataManager @Inject constructor(private val api: ApiHelper,private val preferencesHelper: PreferencesHelper) : DataManager {


    override fun getUser(): UserModel? = preferencesHelper.getUser()

    override fun setUser(model: UserModel?) = preferencesHelper.setUser(model)


    override fun getCurrentUserLoggedMode(): Int? {
        return preferencesHelper.getCurrentUserLoggedMode()
    }

    override fun setCurrentUserLoggedMode(mode: DataManager.LoggedMode?) {
        preferencesHelper.setCurrentUserLoggedMode(mode)
    }

    override fun login(req:LoginReq) = api.login(req)
}