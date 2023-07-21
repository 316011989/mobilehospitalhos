package com.zyl.mobilehospitalhos.hosui

import android.content.Intent
import android.os.Bundle
import com.zyl.mobilehospitalhos.R
import com.zyl.mobilehospitalhos.base.BaseActivity
import com.zyl.mobilehospitalhos.databinding.ActivityHousongTaskdetailBinding
import com.zyl.mobilehospitalhos.databinding.ActivityHousongTaskdispatchBinding

class HouSongTaskDispatchActivity : BaseActivity() {
    private lateinit var binding: ActivityHousongTaskdispatchBinding
    private var dispatchState = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHousongTaskdispatchBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.hsTaskBtn1.setOnClickListener {
            finish()
        }
        binding.hsTaskBtn3.setOnClickListener {
            if (dispatchState == 0) {
                binding.housongBackground.setBackgroundResource(R.mipmap.frame311)
                dispatchState++
            } else if (dispatchState == 1) {
                val intent = Intent()
                intent.setClass(this, HouSongManageActivity::class.java)
                startActivity(intent)
            }
        }
    }
}