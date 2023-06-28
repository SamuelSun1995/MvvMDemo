package com.yifan.mvvmdemo

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner

class MyObserver : LifecycleEventObserver {
    val TAG = "LifecyclesActivity"
    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        Log.i(TAG,"onStateChanged==============source:" + source + "  event:" + event)
    }
}