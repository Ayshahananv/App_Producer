package com.testing.app_producer.features

import android.util.Log
import net.soti.xtsocket.transform.enums.FeatureType
import net.soti.xtsocket.transform.enums.ReturnType
import net.soti.xtsocket.transform.models.Feature

object DataList {
    fun get():List<Feature>{
        Log.d("Aysha", "get: datalist started")
        var dataList= ArrayList<Feature>()
        dataList.add(Feature("android_version", ReturnType.STRING, "version of android",FeatureType.POLL))
        dataList.add(Feature("manufacturer", ReturnType.STRING,"Name of manufacturer", FeatureType.POLL))
        dataList.add(Feature("version", ReturnType.INTEGER,"Platform build version", FeatureType.POLL))
        dataList.add(Feature("model", ReturnType.STRING,"Device Model", FeatureType.POLL))
        dataList.add(Feature("wifi_status", ReturnType.STRING,"wifi state Enabled/Disabled", FeatureType.EVENT))
        dataList.add(Feature("ip", ReturnType.STRING,"IP address of connected device", FeatureType.POLL))
        val deviceUsageProperty= Feature("device_usage",ReturnType.ARRAY,"device data usage",FeatureType.EVENT)
        deviceUsageProperty.args.add(Feature("start_time",ReturnType.LONG))
        deviceUsageProperty.args.add(Feature("end_time",ReturnType.LONG))
        deviceUsageProperty.arrayItem =ReturnType.OBJECT
        deviceUsageProperty.objectItems.add(Feature("tx_bytes",ReturnType.LONG))
        deviceUsageProperty.objectItems.add(Feature("rx_bytes",ReturnType.LONG))
        dataList.add(deviceUsageProperty)
        Log.d("Aysha", "get: $dataList")
        Log.d("Aysha", "get: datalist ended")
//        var loadedData =ArrayList<Feature>()
//        for(i in 1..5000){
//            loadedData.addAll(dataList)
//        }
//        Log.d("Aysha", "get: $loadedData")

        return dataList
    }
}