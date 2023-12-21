package com.espmisti.asoanalytics.network.request

interface IRequest {
    suspend fun send(value: String): Boolean
}