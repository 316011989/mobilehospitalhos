package com.zyl.mobilehospitalhos.hosui

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.zyl.mobilehospitalhos.R
import com.zyl.mobilehospitalhos.base.BaseActivity
import com.zyl.mobilehospitalhos.databinding.ActivityHousongManageBinding

class HouSongManageActivity : BaseActivity(), View.OnClickListener {

    private lateinit var binding: ActivityHousongManageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHousongManageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.hsTaskBtn1.setOnClickListener(this)
        binding.hsTaskBtn2.setOnClickListener(this)
        binding.hsTaskBtn3.setOnClickListener(this)
        binding.hsTaskBtn4.setOnClickListener(this)
        binding.hsTaskBtn5.setOnClickListener(this)
        binding.hsTaskBtn6.setOnClickListener(this)
        binding.housongListview.setOnClickListener {
            val intent = Intent()
            intent.setClass(this, HouSongTaskDispatchActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.hs_task_btn1 -> {
                binding.housongBackground.setBackgroundResource(R.mipmap.frame316)
            }
            R.id.hs_task_btn2 -> {
                binding.housongBackground.setBackgroundResource(R.mipmap.frame317)
            }
            R.id.hs_task_btn3 -> {}
            R.id.hs_task_btn4 -> {
                binding.housongBackground.setBackgroundResource(R.mipmap.frame316)
            }
            R.id.hs_task_btn5 -> {
                val intent = Intent()
                intent.setClass(this, HouSongRegistActivity::class.java)
                startActivity(intent)
            }
            R.id.hs_task_btn6 -> {
                val intent = Intent()
                intent.setClass(this, HouSongTaskActivity::class.java)
                startActivity(intent)
            }
        }
    }
}