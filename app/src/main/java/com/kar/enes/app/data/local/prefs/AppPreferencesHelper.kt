package com.kar.enes.app.data.local.prefs

import android.content.Context
import androidx.preference.PreferenceManager
import com.google.gson.Gson
import com.google.gson.JsonParser
import com.kar.enes.app.R
import com.kar.enes.app.data.DataManager
import com.kar.enes.app.di.annotations.PreferenceInfo
import com.kar.enes.app.data.model.UserModel
import java.lang.reflect.InvocationTargetException
import javax.inject.Inject

/**
 * Created by M.Enes on 5/9/2019
 */
class AppPreferencesHelper @Inject constructor(val context: Context, @PreferenceInfo val prefFileName: String): PreferencesHelper {


    private val PREF_KEY_USER = "PREF_KEY_USER"
    private val PREF_KEY_LOGGED_MODE = "PREF_KEY_LOGGED_MODE"
    val mPrefs = PreferenceManager.getDefaultSharedPreferences(context)


    override fun isDarkTheme(): Boolean = mPrefs.getBoolean(context.getString(R.string.PREF_KEY_DARK_THEME),false)
    override fun setDarkTheme(boolean: Boolean) {
        mPrefs.edit().putBoolean(context.getString(R.string.PREF_KEY_DARK_THEME),boolean).apply()
    }

    override fun getUser(): UserModel? = getComplex(PREF_KEY_USER, UserModel::class.java)
    override fun setUser(model: UserModel?) {
        saveComplex(PREF_KEY_USER,model)
    }

    override fun getCurrentUserLoggedMode(): Int = mPrefs.getInt(PREF_KEY_LOGGED_MODE, DataManager.LoggedMode.LOGGED_OUT.type)
    override fun setCurrentUserLoggedMode(mode: DataManager.LoggedMode?) {
        if (mode != null) {
            mPrefs.edit().putInt(PREF_KEY_LOGGED_MODE, mode.type).apply()
        }else{
            mPrefs.edit().putInt(PREF_KEY_LOGGED_MODE, DataManager.LoggedMode.LOGGED_OUT.type).apply()
        }
    }

    fun <T> saveComplex(key: String, complex: T): Boolean {
        val editor = mPrefs.edit()
        editor.putString(key,  Gson().toJson(complex))
        return editor.commit()
    }

    @Suppress("UNCHECKED_CAST")
    fun <T> getComplex(key: String, type: Class<T>): T? {
        val data = mPrefs.getString(key, null)
        if (data != null && data != "null") {
            val mJson = JsonParser().parse(data)
            return Gson().fromJson<T>(mJson, type)
        }
        val ctor = type.constructors
        try {
            return ctor[0].newInstance() as T
        } catch (e: InstantiationException) {
            e.printStackTrace()
        } catch (e: IllegalAccessException) {
            e.printStackTrace()
        } catch (e: InvocationTargetException) {
            e.printStackTrace()
        }

        return null
    }
}