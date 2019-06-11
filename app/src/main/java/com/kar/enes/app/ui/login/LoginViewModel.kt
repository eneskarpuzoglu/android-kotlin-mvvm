package com.kar.enes.app.ui.login

import com.kar.enes.app.data.remote.ApiObserver
import com.kar.enes.app.data.DataManager
import com.kar.enes.app.data.model.request.LoginReq
import com.kar.enes.app.data.model.api.ErrorData
import com.kar.enes.app.data.model.response.LoginResponse
import com.kar.enes.app.ui.base.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

/**
 * Created by M.Enes on 24.04.2019
 */
class LoginViewModel @Inject constructor(dataManager: DataManager): BaseViewModel<LoginNavigator>(dataManager) {

    var username: String =""
    var password: String =""


    fun login(email: String,password: String){
        val req = LoginReq(email,password)
        displayLoader(true)
        dataManager.login(req)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object: ApiObserver<LoginResponse>(compositeDisposable){
                override fun onSuccess(data: LoginResponse) {
                    displayLoader(false)
                    if (data.status.equals("Success")) {
                        Timber.i("AAA {${data.model!!.name}}")
                        dataManager.setUser(data.model!!)
                        dataManager.setCurrentUserLoggedMode(DataManager.LoggedMode.LOGGED_IN)
                    }else{
                        Timber.i("AAA {${data.flash!!.get(0).message}}")
                    }
                }

                override fun onError(e: ErrorData) {
                    displayLoader(false)
                    error.value = e
                    Timber.i("AAA ${e.message} ${e.throwable}")
                }
            })
    }

    fun afterEmailTextChanged(s: CharSequence) {
        username = s.toString()
    }

    fun afterPasswordTextChanged(s: CharSequence) {
        password = s.toString()
    }

    fun clickLogin() {
        Timber.i("$username $password")
        if (username.isEmpty() || password.isEmpty()) {
            Timber.i("bos olamaz")
            return
        }
        login(username,password)
    }

}