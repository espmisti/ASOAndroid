package com.espmisti.asoanalytics.network

object Config {
    const val URL = "http://45.145.0.62:8080/api/"
    const val CALL_MINUTES: Long = 2

    object ROUTES {
        const val INSERT = "stats/insert"
    }

    object LOG {
        const val NETWORK = "app_network"
    }
}