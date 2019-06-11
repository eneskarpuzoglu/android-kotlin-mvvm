package com.kar.enes.app.data.remote

import com.kar.enes.app.data.model.api.ErrorData
import io.reactivex.Observer
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Created by M.Enes on 25.04.2019
 */
abstract class ApiObserver<T> constructor(private val compositeDisposable: CompositeDisposable): Observer<T> {
    override fun onComplete() {

    }

    override fun onSubscribe(d: Disposable) {
        compositeDisposable.add(d)
    }

    override fun onNext(t: T) {
        onSuccess(t)
    }

    override fun onError(e: Throwable) {
        onError(ErrorData(throwable = e))
    }

    abstract fun onSuccess(data: T)
    abstract fun onError(e: ErrorData)
}