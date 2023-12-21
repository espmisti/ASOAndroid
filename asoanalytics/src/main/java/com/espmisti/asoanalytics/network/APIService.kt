package com.espmisti.asoanalytics.network

import com.espmisti.asoanalytics.network.Config.CALL_MINUTES
import com.espmisti.asoanalytics.network.Config.URL
import okhttp3.OkHttpClient
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.Body
import retrofit2.http.POST
import java.util.concurrent.TimeUnit

interface APIService {

    @POST(Config.ROUTES.INSERT)
    suspend fun sendAnalytics(
        @Body body: RequestBody
    ): Response<ResponseBody>

    companion object {
        private val okHttpClient = OkHttpClient.Builder()
            .callTimeout(CALL_MINUTES, TimeUnit.MINUTES)
            .connectTimeout(CALL_MINUTES, TimeUnit.MINUTES)
            .readTimeout(CALL_MINUTES, TimeUnit.MINUTES)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(URL)
            .client(okHttpClient)
            .build()
            .create(APIService::class.java)
    }
}