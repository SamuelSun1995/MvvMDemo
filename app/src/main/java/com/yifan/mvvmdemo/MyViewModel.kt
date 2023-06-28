package com.yifan.mvvmdemo

import android.util.Log
import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel() {

    private val TAG: String = "ViewModelActivity"

    override fun onCleared() {
        super.onCleared()
        Log.i(TAG, "onCleared ==> " + this.hashCode())
    }
}