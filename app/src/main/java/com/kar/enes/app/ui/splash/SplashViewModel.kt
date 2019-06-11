package com.kar.enes.app.ui.splash

import com.kar.enes.app.data.DataManager
import com.kar.enes.app.data.model.UserModel
import com.kar.enes.app.ui.base.BaseViewModel
import java.util.*
import javax.inject.Inject
import kotlin.concurrent.schedule

/**
 * Created by M.Enes on 5/9/2019
 */
class SplashViewModel @Inject constructor(dataManager: DataManager): BaseViewModel<SplashNavigator>(dataManager) {

    fun start(){
        val user: UserModel? = dataManager.getUser()
        if (user?.token != null) {
            Timer("SettingUp", false).schedule(3000){
                getNavigator()?.openMainActivity()
            }

        }else{
            Timer("SettingUp", false).schedule(3000){
                getNavigator()?.openLoginActivity()
            }
        }
    }
}