package com.kar.enes.app.data.remote

import com.kar.enes.app.data.model.request.LoginReq
import com.kar.enes.app.data.model.response.LoginResponse
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * Created by M.Enes on 5/8/2019
 */
interface ApiHelper {

    @POST("users/authtoken")
    fun login(@Body req:LoginReq): Observable<LoginResponse>
}