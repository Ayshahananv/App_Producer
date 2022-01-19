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
        private const val TAG = "Aysha"
        fun build(context: Context) {
            Log.d(TAG, "build: started")
                FeatureBuilder(context).advertiseDataList(DataList.get())
                    .version(1)
                    .build(FeatureController(context))
            Log.d("Aysha", "build function ended")
        }
    }

}