package com.sid.calldetector

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.telephony.TelephonyManager
import android.util.Log
import android.widget.Toast


class IncomingCallReceiver : BroadcastReceiver() {


    override fun onReceive(context: Context, intent: Intent) {

        val action = intent.action

        // This method is called when the BroadcastReceiver is receiving an Intent broadcast.
        val state = intent.getStringExtra(TelephonyManager.EXTRA_STATE)

        if (TelephonyManager.EXTRA_STATE_RINGING == state) {
            // You can do something with the incoming number here

            val incomingNumber = intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER)
            Log.d("IncomingCallReceiver", "Incoming call from: $incomingNumber")

            Toast.makeText(context, "Incoming call from $incomingNumber", Toast.LENGTH_SHORT).show()

        } else if (TelephonyManager.EXTRA_STATE_OFFHOOK == state) {

            // This is when the call is picked up
            Log.d("IncomingCallReceiver", "Call picked up")
            Toast.makeText(context, "Call picked up", Toast.LENGTH_SHORT).show()

        } else if (TelephonyManager.EXTRA_STATE_IDLE == state) {
            // This is when the call ends
            Log.d("IncomingCallReceiver", "Call ended or missed")
        }
    }
}