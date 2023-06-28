package com.yifan.mvvmdemo

import androidx.lifecycle.ViewModel

/**
 * 写一个计数程序，每按一次按钮屏幕上的数字就加一，ViewModel存放count
 */
class MainViewModel: ViewModel() {
    var mCnt = 0
}