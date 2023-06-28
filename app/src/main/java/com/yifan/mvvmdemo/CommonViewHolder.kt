package com.yifan.mvvmdemo

import android.view.View
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

/**
 * 主构造函数
 */
class CommonViewHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private lateinit var mViewBinding: ViewBinding


    /**
     * 次构造函数
     */
    constructor(viewBinding: ViewBinding, itemView: View) : this(itemView) {
        this.mViewBinding = viewBinding
    }
}