package com.kar.enes.app.ui.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kar.enes.app.data.DataManager
import com.kar.enes.app.data.model.api.ErrorData
import io.reactivex.disposables.CompositeDisposable
import java.lang.ref.WeakReference

/**
 * Created by M.Enes on 24.04.2019
 */
open class BaseViewModel<N>(
    val dataManager: DataManager
): ViewModel() {


    private var mNavigator: WeakReference<N>? = null
    val loader: MutableLiveData<Boolean> = MutableLiveData()
    val error: MutableLiveData<ErrorData?> = MutableLiveData()
    var compositeDisposable: CompositeDisposable = CompositeDisposable()

    fun displayLoader(isLoading: Boolean) {
        loader.value = isLoading
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }


    fun getNavigator(): N? {
        return mNavigator?.get()
    }

    fun setNavigator(navigator: N) {
        this.mNavigator = WeakReference(navigator)
    }
}