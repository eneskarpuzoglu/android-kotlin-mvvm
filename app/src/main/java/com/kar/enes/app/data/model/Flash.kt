package com.kar.enes.app.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by M.Enes on 24.04.2019
 */
class Flash {

    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("message")
    @Expose
    var message: String? = null
}