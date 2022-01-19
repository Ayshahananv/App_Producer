package com.testing.app_producer.features

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import net.soti.xtsocket.transform.feature.EventBasedFeature
import 	android.net.wifi.WifiManager
import android.util.Log
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.testing.app_producer.receivers.BatterReceiver
import com.testing.app_producer.receivers.WifiStateReceiver
import net.soti.xtsocket.transform.collector.Event
import net.soti.xtsocket.transform.models.XTSType
import org.json.JSONObject

class WifiEvent(val context:Context):EventBasedFeature(){
    private  val TAG = "Aysha"
    companion object{
        lateinit var wifiManager: WifiManager
    }
    var broadcastReceiver:BroadcastReceiver=WifiStateReceiver()
    override fun start() {
        Log.d(TAG, "start: event started")
            val intentFilter=IntentFilter()
            intentFilter.addAction(WifiManager.WIFI_STATE_CHANGED_ACTION)
            //LocalBroadcastManager.getInstance(context).registerReceiver(broadcastReceiver,intentFilter)
            context.registerReceiver(broadcastReceiver, intentFilter)
            Log.d(TAG, "Start: broadcast receiver start")
    }
//    override fun start() {
//        try {
//            Log.d(TAG, "start: event started")
//            val intentFilter=IntentFilter()
//            intentFilter.addAction(WifiManager.WIFI_STATE_CHANGED_ACTION)
//            //LocalBroadcastManager.getInstance(context).registerReceiver(broadcastReceiver,intentFilter)
//            context.registerReceiver(broadcastReceiver, intentFilter)
//            Log.d(TAG, "Start: broadcast receiver start")
//        }
//        catch (e:IllegalStateException){
//            throw Exception("too many receivers")
//        }
//
//    }

    override fun stop() {
        context.unregisterReceiver(broadcastReceiver)
        Log.d(TAG, "stop: broadcast stopped")
    }

}