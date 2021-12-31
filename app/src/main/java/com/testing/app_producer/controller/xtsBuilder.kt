package com.testing.app_producer.controller

import android.content.Context
import android.util.Log
import com.testing.app_producer.features.DataList
import net.soti.xtsocket.transform.feature.FeatureBuilder
import net.soti.xtsocket.transform.feature.FeatureDirectory
import net.soti.xtsocket.transform.interfaces.IFeature
import net.soti.xtsocket.transform.models.Feature

class xtsBuilder {
    companion object {
        fun build(context: Context) {
            Log.d("Aysha", "build: started")
            FeatureBuilder(context).version(1).advertiseDataList(DataList.get())
                .build(FeatureController(context))
            Log.d("Aysha", "build function ended")
        }
    }

}