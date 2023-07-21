package com.zyl.mobilehospitalhos.hosui

import android.content.Intent
import android.os.Bundle
import com.zyl.mobilehospitalhos.base.BaseActivity
import com.zyl.mobilehospitalhos.databinding.ActivityHousongTaskdetailBinding

class HouSongTaskDetailActivity : BaseActivity() {
    private lateinit var binding: ActivityHousongTaskdetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHousongTaskdetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.hsTaskBtn1.setOnClickListener {
            finish()
        }
        binding.hsTaskBtn3.setOnClickListener {
            val intent = Intent()
            intent.setClass(this, HouSongManageActivity::class.java)
            startActivity(intent)
        }
    }
}