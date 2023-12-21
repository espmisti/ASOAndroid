package com.espmisti.asoanalytics.network

import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONObject

object Utils {
    fun String.toRequestBody(): RequestBody {
        val json = JSONObject().apply { put("referrer", this@toRequestBody) }.toString()
        return json.toRequestBody("application/json".toMediaTypeOrNull())
    }
}