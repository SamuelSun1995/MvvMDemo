package com.yifan.mvvmdemo

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.Observable
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.yifan.mvvmdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mViewModel: MainViewModel

    private val TAG = "MainActivity"

    private lateinit var mDataBinding: ActivityMainBinding

    private val mLiveData = MutableLiveData<String>()

    var cntName = 0

    val dogName = arrayOf("dog1", "dog2", "dog3", "dog4", "dog5", "dog6")

    val dogColor =
        arrayOf("dogColor1", "dogColor2", "dogColor3", "dogColor4", "dogColor5", "dogColor6")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        mDataBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mDataBinding.root)
        /**通过ViewModelP rovider 来获取ViewModel 的实例
         * 因为ViewModel 有其独立的生命周期，并且其生命周期要长于Activity 。
         * 如果我们在onCreate()方法中创建ViewModel 的实例，那么每次onCreate()方法执行的时
         * 候，ViewModel 都会创建一个新的实例，这样当手机屏幕发生旋转的时候，就无法保留其中的
         * 数据了
         */
        mViewModel = ViewModelProvider(this)[MainViewModel::class.java]
        mDataBinding.setOnePlusOnClick {
            mViewModel.mCnt++
            refreshCounter()
        }
        refreshCounter()

        var userName = ObservableField<String>()
        mDataBinding.username = userName
        val dog = Dog()
        mDataBinding.dog = dog
        mDataBinding.btnName.setOnClickListener {
            dog.addOnPropertyChangedCallback(object : Observable.OnPropertyChangedCallback() {
                override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                    when (propertyId) {
                        BR.dogName -> {
                            Log.e("看看刷新了哪", "刷新了name")
                        }

                        BR.color -> {
                            Log.e("看看刷新了哪", "全部全部")
                        }

                        else -> {
                            Log.e("看看刷新了哪", "未知错误~")
                        }
                    }
                }
            })
            if (cntName == 6) cntName = 0
            dog.setDataOnlyName(dogName[cntName], dogColor[cntName])
            cntName++
        }

        //=========================================LIVEDATA
        mDataBinding.onlyLive = mLiveData.value

        mLiveData.observe(this) { t ->
            mDataBinding.onlyLive = t
            Log.i(TAG, "单独使用LiveData ==> " + t);
        }
    }

    override fun onStop() {
        super.onStop()
        mLiveData.postValue("onStop______________post__________")
    }

    //用来刷新当前的
    private fun refreshCounter() {
        mDataBinding.textStr = mViewModel.mCnt.toString()
    }
}