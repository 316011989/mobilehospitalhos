package com.zyl.mobilehospitalhis.base

import android.app.Activity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import com.zyl.mobilehospitalhis.R


open class BaseActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
//        setStatusBarColor(ContextCompat.getColor(this, R.color.blueButton))
    }

    private fun setStatusBarColor(statusColor: Int) {
        val window = window
        //取消状态栏透明
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        //添加Flag把状态栏设为可绘制模式
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        //设置状态栏颜色
        window.statusBarColor = statusColor
        //设置系统状态栏处于可见状态
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_VISIBLE
        //让view不根据系统窗口来调整自己的布局
        val mContentView = window.findViewById<View>(Window.ID_ANDROID_CONTENT) as ViewGroup
        val mChildView = mContentView.getChildAt(0)
        if (mChildView != null) {
            ViewCompat.setFitsSystemWindows(mChildView, false)
            ViewCompat.requestApplyInsets(mChildView)
        }
    }
}