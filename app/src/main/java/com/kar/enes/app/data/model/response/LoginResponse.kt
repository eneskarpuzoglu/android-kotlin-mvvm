package com.kar.enes.app.data.model.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.kar.enes.app.data.model.Flash
import com.kar.enes.app.data.model.UserModel

/**
 * Created by M.Enes on 24.04.2019
 */
class LoginResponse{
    @SerializedName("status")
    @Expose
    var status: String? = null
    @SerializedName("type")
    @Expose
    var type: String? = null
    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("model")
    @Expose
    var model: UserModel? = null
    @SerializedName("flash")
    @Expose
    var flash: List<Flash>? = null
}