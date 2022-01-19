package com.testing.app_producer.receivers

import android.net.wifi.WifiManager

import android.content.Intent

import android.content.BroadcastReceiver
import android.content.Context
import android.util.Log
import android.widget.Switch;
import net.soti.xtsocket.transform.collector.Event
import net.soti.xtsocket.transform.models.XTSType
import org.json.JSONObject
import java.lang.NullPointerException
import java.lang.RuntimeException

public class WifiStateReceiver :BroadcastReceiver(){
    private  val TAG = "Aysha"
    override fun onReceive(context: Context?, intent: Intent) {
        val wifiStateExtra = intent.getIntExtra(
            WifiManager.EXTRA_WIFI_STATE,
            WifiManager.WIFI_STATE_UNKNOWN
        )
//        try {
            when (wifiStateExtra) {
                WifiManager.WIFI_STATE_ENABLED -> {
                    val wifiEnabledJson= JSONObject()
                    wifiEnabledJson.put("wifi_status","Wifi state enabled")
                    Event().onEventData("wifi_status", XTSType("Enabled"))
                    Log.d(TAG, "onReceive: wifi on")
                }
                WifiManager.WIFI_STATE_DISABLED -> {
                    val wifiDisabledJson= JSONObject()
                    wifiDisabledJson.put("wifi_status","Wifi state disabled")
                    Event().onEventData("wifi_status", XTSType("Disabled"))
                    Log.d(TAG, "onReceive: wifi off")

                }
            }

//        }
//        catch (e:UninitializedPropertyAccessException){
//
//        }
//        catch (e:RuntimeException){
//
//        }

    }


    }

