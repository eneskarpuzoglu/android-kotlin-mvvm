package com.kar.enes.app.ui.launch.login

import android.app.Activity
import android.content.Context

/**
 * Created by M.Enes on 10/21/2020.
 */
interface LoginNavigator {

    fun activity(): Activity

    fun context(): Context

    fun setDay()

    fun setNight()
}