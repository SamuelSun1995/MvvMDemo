package com.yifan.mvvmdemo

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable

/**
 * bean对象需要继承 BaseObservable
 * @Bindable 标注用来表示哪个字段需要单向绑定。public修饰的可以直接用@Bindable绑定。private修饰的需要在get()方法上用@Bindable标注
 * notifyChange();刷新所有字段，notifyPropertyChanged(com.lihang.databindinglover.BR.name);刷新单个字段。注意这里说的刷新全是被@Bindable绑定的。如果BR.name出不来。建议build下项目
 */
class Dog : BaseObservable() {
    @Bindable
     var dogName: String? = null
        set(value) {
            field = value
            notifyPropertyChanged(BR.dogName)
        }

    @Bindable
     var color: String? = null

    fun setDataOnlyName(name: String, color: String) {
        this.dogName = name
//        this.color = color
        //只刷新name字段
        notifyPropertyChanged(BR.dogName)
    }
}