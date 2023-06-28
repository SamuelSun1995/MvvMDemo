package com.yifan.mvvmdemo

import android.app.Activity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

class LifecyclesActivity : Activity(), LifecycleOwner {

    val TAG = "LifecyclesActivity"

    val mLiveData = MutableLiveData<String>()

    val mLifecycleRegistry = LifecycleRegistry(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycle.addObserver(MyObserver::class.java.newInstance())
        mLiveData.observe(this) { t ->
            Log.i(TAG, "observe========================" + t)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        Log.i(TAG, "onSaveInstanceState========================")
        mLifecycleRegistry.currentState = Lifecycle.State.CREATED
        super.onSaveInstanceState(outState)
    }

    override fun getLifecycle(): Lifecycle {
        return mLifecycleRegistry
    }

    override fun onStop() {
        super.onStop()
        mLiveData.postValue("onStop=====================>运行试试")
    }
}