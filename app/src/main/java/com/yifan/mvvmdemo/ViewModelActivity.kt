package com.yifan.mvvmdemo

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ViewModelActivity : FragmentActivity() {


    private val TAG: String = "ViewModelActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val myViewModel = ViewModelProvider(this)[MyViewModel::class.java]
        Log.i(TAG, "onCreate ==> " + myViewModel.hashCode())
    }

    override fun onStart() {
        super.onStart()
        val myViewModel = ViewModelProvider(this)[MyViewModel::class.java]
        Log.i(TAG, "onStart ==> " + myViewModel.hashCode())
    }

    override fun onResume() {
        super.onResume()
        val myViewModel = ViewModelProvider(this)[MyViewModel::class.java]
        Log.i(TAG, "onResume ==> " + myViewModel.hashCode())
    }

    override fun onPause() {
        super.onPause()
        val myViewModel = ViewModelProvider(this)[MyViewModel::class.java]
        Log.i(TAG, "onPause ==> " + myViewModel.hashCode())
    }

    override fun onStop() {
        super.onStop()
        val myViewModel = ViewModelProvider(this)[MyViewModel::class.java]
        Log.i(TAG, "onStop ==> " + myViewModel.hashCode())
    }

    override fun onDestroy() {
        super.onDestroy()
        val myViewModel = ViewModelProvider(this)[MyViewModel::class.java]
        Log.i(TAG, "onDestroy ==> " + myViewModel.hashCode())
    }
}