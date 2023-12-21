package com.espmisti.asoanalytics

import com.espmisti.asoanalytics.network.request.RequestRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ASOAnalytics : IASOAnalytics {
    override fun send(value: String, onSuccess: (() -> Unit)?) {
        CoroutineScope(Dispatchers.IO).launch {
            val response = RequestRepository().send(value = value)
            withContext(Dispatchers.Main) {
                if (response) onSuccess?.invoke()
            }
        }
    }
}