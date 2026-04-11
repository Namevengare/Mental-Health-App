package com.example.mentalhealthapp.notifications

import okhttp3.*
import okio.ByteString

class WebSocketManager(private val notificationHelper: NotificationHelper) {
    private var client: OkHttpClient = OkHttpClient()
    private var webSocket: WebSocket? = null

    fun connect(url: String) {
        val request = Request.Builder().url(url).build()
        webSocket = client.newWebSocket(request, object : WebSocketListener() {
            override fun onOpen(webSocket: WebSocket, response: Response) {
                println("WebSocket Connected")
            }

            override fun onMessage(webSocket: WebSocket, text: String) {

                notificationHelper.showNotification("Nueva Notificación", text)
            }

            override fun onMessage(webSocket: WebSocket, bytes: ByteString) {
            }

            override fun onClosing(webSocket: WebSocket, code: Int, reason: String) {
                webSocket.close(1000, null)
                println("WebSocket Closing: $reason")
            }

            override fun onFailure(webSocket: WebSocket, t: Throwable, response: Response?) {
                println("WebSocket Failure: ${t.message}")
            }
        })
    }

    fun disconnect() {
        webSocket?.close(1000, "App Closing")
    }
}
