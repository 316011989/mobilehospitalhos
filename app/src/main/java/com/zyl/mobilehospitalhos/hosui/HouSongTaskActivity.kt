package com.zyl.mobilehospitalhos.hosui

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.zyl.mobilehospitalhos.R
import com.zyl.mobilehospitalhos.base.BaseActivity
import com.zyl.mobilehospitalhos.databinding.ActivityHousongTaskBinding

class HouSongTaskActivity : BaseActivity(), View.OnClickListener {
    private lateinit var binding: ActivityHousongTaskBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHousongTaskBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.hsTaskBtn1.setOnClickListener(this)
        binding.hsTaskBtn2.setOnClickListener(this)
        binding.hsTaskBtn3.setOnClickListener(this)
        binding.hsTaskBtn4.setOnClickListener(this)
        binding.hsTaskBtn5.setOnClickListener(this)
        binding.housongListview.setOnClickListener {
            val intent = Intent()
            intent.setClass(this, HouSongTaskDetailActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.hs_task_btn1 -> {
                binding.housongBackground.setBackgroundResource(R.mipmap.frame314)
            }
            R.id.hs_task_btn2 -> {
                binding.housongBackground.setBackgroundResource(R.mipmap.frame315)
            }
            R.id.hs_task_btn3 -> {
                val intent = Intent()
                intent.setClass(this, HouSongManageActivity::class.java)
                startActivity(intent)
            }
            R.id.hs_task_btn4 -> {
                val intent = Intent()
                intent.setClass(this, HouSongRegistActivity::class.java)
                startActivity(intent)
            }
            R.id.hs_task_btn5 -> {
                binding.housongBackground.setBackgroundResource(R.mipmap.frame314)
            }
        }
    }
}