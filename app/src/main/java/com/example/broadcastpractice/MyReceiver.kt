package com.example.broadcastpractice

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast

class MyReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        Log.d("11111111", "onReceive");
        Toast.makeText(context,"onReceived broadcast", Toast.LENGTH_SHORT).show()
    }
}

val AIRPLANE_ACTION = Intent.ACTION_AIRPLANE_MODE_CHANGED
val MY_ACTION = "com.example.broadcastpractice.myaction"