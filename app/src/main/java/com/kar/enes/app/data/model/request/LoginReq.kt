package com.kar.enes.app.data.model.request

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by M.Enes on 5/8/2019
 */
class LoginReq constructor(
    @SerializedName("email")
    @Expose
    val email:String,
    @SerializedName("password")
    @Expose
    val password:String) {
}