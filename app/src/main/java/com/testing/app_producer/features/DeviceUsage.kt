package com.testing.app_producer.features

import net.soti.xtsocket.transform.collector.Event
import net.soti.xtsocket.transform.feature.EventBasedFeature
import net.soti.xtsocket.transform.models.XTSType
import org.json.JSONObject

class DeviceUsage:EventBasedFeature() {
    override fun start() {
        val deviceUsageJson= JSONObject()
        deviceUsageJson.put("tx_bytes",768456)
        deviceUsageJson.put("rx_bytes",876593)
        Event().onEventData("device_usage", XTSType(deviceUsageJson))
    }

    override fun stop() {
        TODO("Not yet implemented")
    }
}