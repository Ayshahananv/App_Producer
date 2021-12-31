package com.testing.app_producer.controller

import android.content.Context
import android.os.Build
import android.util.Log
import com.testing.app_producer.EventFactory
import com.testing.app_producer.features.DeviceUsage
import com.testing.app_producer.features.WifiEvent
import com.testing.app_producer.receivers.WifiStateReceiver
import net.soti.xtsocket.transform.interfaces.IFeature
import net.soti.xtsocket.transform.interfaces.IType
import net.soti.xtsocket.transform.models.XTSType
import org.json.JSONObject

class FeatureController(private val context:Context):IFeature {

    override fun getData(property: String, inputArg: JSONObject?):IType{
        Log.d("Aysha", "getData: ")
        return when(property){
            "model"->XTSType(Build.MODEL)
            "manufacturer"-> XTSType(Build.MANUFACTURER)
            "ip"-> XTSType(Build.BRAND)
            //"wifi_status"-> XTSType(WifiEvent)
            else -> XTSType(Build.USER)
        }
    }

    override fun startEvent(property: String) {
        Log.d("Aysha", "startEvent: ")
        if(property=="wifi_status"){
            Log.d("Aysha", "startEvent: wifievent")
            WifiEvent(context).start()
        }
        if(property=="device_usage"){
            Log.d("Aysha", "startEvent: deviceusage")
            DeviceUsage().start()
        }
    }

    override fun stopEvent(property: String) {
        if(property=="wifi_status"){
            WifiEvent(context).stop()
        }
        if(property=="device_usage"){
            DeviceUsage().stop()
        }
    }
}