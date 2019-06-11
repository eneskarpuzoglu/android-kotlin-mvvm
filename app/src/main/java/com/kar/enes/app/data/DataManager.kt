package com.kar.enes.app.data

import com.kar.enes.app.data.local.prefs.PreferencesHelper
import com.kar.enes.app.data.remote.ApiHelper

/**
 * Created by M.Enes on 5/9/2019
 */
interface DataManager: PreferencesHelper, ApiHelper {

    enum class LoggedMode constructor(val type: Int) {

        LOGGED_OUT(0),
        LOGGED_IN(1),
    }

}