package com.testing.app_producer.features

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import net.soti.xtsocket.transform.feature.EventBasedFeature
import 	android.net.wifi.WifiManager
import android.util.Log
import com.testing.app_producer.receivers.BatterReceiver
import com.testing.app_producer.receivers.WifiStateReceiver
import net.soti.xtsocket.transform.collector.Event
import net.soti.xtsocket.transform.models.XTSType
import org.json.JSONObject

class WifiEvent(val context:Context):EventBasedFeature() {
    private  val TAG = "Aysha"
    companion object{
        lateinit var wifiManager: WifiManager

    }
    var broadcastReceiver:BroadcastReceiver=WifiStateReceiver()

//    override fun start(){
////        Log.d(TAG, "start:wifiEvent ")
////        wifiManager.setWifiEnabled(true)
////        val wifiEnabledJson=JSONObject()
////        wifiEnabledJson.put("wifi_status","Wifi state enabled")
////        Event().onEventData("wifi_status",XTSType(wifiEnabledJson))
//        val intentFilter = IntentFilter()
//        intentFilter.addAction(WifiManager.WIFI_STATE_CHANGED_ACTION)
//        context.registerReceiver(broadcastReceiver, intentFilter)
//        Log.d(TAG, "start: broadcastreceiver started")
//    }
    override fun start() {

        Log.d(TAG, "start: event started")
        val intentFilter=IntentFilter()
        intentFilter.addAction(WifiManager.WIFI_STATE_CHANGED_ACTION)
        context.registerReceiver(broadcastReceiver, intentFilter)
        Log.d(TAG, "Start: broadcast receiver start")
    }


    override fun stop() {
//        wifiManager.setWifiEnabled(false)
//        val wifiDisabledJson=JSONObject()
//        wifiDisabledJson.put("wifi_status","Wifi state disabled")
//        Event().onEventData("wifi_status",XTSType(wifiDisabledJson))
        context.unregisterReceiver(broadcastReceiver)
        Log.d(TAG, "stop: broadcast stopped")

    }
}