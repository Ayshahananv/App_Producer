package com.testing.app_producer

import android.content.Context
import com.testing.app_producer.features.WifiEvent
import com.testing.app_producer.receivers.WifiStateReceiver
import net.soti.xtsocket.transform.feature.EventBasedFeature

public class EventFactory(val context:Context){
    fun getFeature(eventProperty: String): EventBasedFeature? {
        /*return if (BatteryData.batteryKeys.contains(eventProperty))
            BatteryData()
        else
            null*/
        if(eventProperty=="wifi_status"){
            return WifiEvent(context)
        }
        return null
    }
}