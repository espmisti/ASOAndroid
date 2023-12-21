package com.espmisti.asoanalytics.network.request

import android.util.Log
import com.espmisti.asoanalytics.network.APIService.Companion.retrofit
import com.espmisti.asoanalytics.network.Config.LOG.NETWORK
import com.espmisti.asoanalytics.network.Utils.toRequestBody

class RequestRepository : IRequest {
    override suspend fun send(value: String): Boolean {
        val response = retrofit.sendAnalytics(body = value.toRequestBody())
        return if (response.isSuccessful) {
            Log.d(NETWORK, "[Success]: The data was sent and received on the server.")
            true
        } else {
            Log.e(NETWORK, "[Error]: This is organic join.")
            false
        }
    }
}