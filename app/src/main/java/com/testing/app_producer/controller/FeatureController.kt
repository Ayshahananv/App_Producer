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
import java.lang.IllegalStateException
import java.math.BigInteger


class FeatureController(private val context:Context):IFeature {

    override fun getData(property: String, inputArg: JSONObject?):IType{
        Log.d("Aysha", "getData: ")
        return when(property){
            "model"->XTSType(Build.MODEL)
            "manufacturer"-> XTSType(Build.MANUFACTURER)
            "ip"-> XTSType(Build.BRAND)
            else -> XTSType(Build.USER)
        }
    }

    override fun startEvent(property: String) {
        Log.d("Aysha", "startEvent: ")
        if (property == "wifi_status") {
            Log.d("Aysha", "startEvent: wifievent")
            //for (i in 1..50000) {
                Log.d("Aysha", "startEvent: loop ")
                WifiEvent(context).start()
           // }
        }
    }

    override fun stopEvent(property: String) {
        Log.d("aysha", "stopEvent: wifi")
        if(property=="wifi_status"){
            WifiEvent(context).stop()
        }
    }
}