package com.espmisti.asoanalytics

interface IASOAnalytics {
    fun send(value: String, onSuccess: (() -> Unit)? = null)
}