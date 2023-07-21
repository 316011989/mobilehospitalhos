package com.zyl.mobilehospitalhos.hosui

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.zyl.mobilehospitalhos.R
import com.zyl.mobilehospitalhos.base.BaseActivity
import com.zyl.mobilehospitalhos.databinding.ActivityHousongRegistBinding

class HouSongRegistActivity : BaseActivity(), View.OnClickListener {

    private lateinit var binding: ActivityHousongRegistBinding
    private var registState = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHousongRegistBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.hsRegistBtn1.setOnClickListener(this)
        binding.hsRegistBtn2.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {

        when (p0?.id) {
            R.id.hs_regist_btn1 -> {
                registState--
            }

            R.id.hs_regist_btn2 -> {
                registState++
                if (registState == 1) {
                    binding.hsRegistBtn1.visibility = View.VISIBLE
                } else {
                    binding.hsRegistBtn1.visibility = View.GONE
                }
            }
        }
        setHouSongBackground()
    }

    private fun setHouSongBackground() {
        when (registState) {
            0 -> {
                binding.housongBackground.setBackgroundResource(R.mipmap.frame319)
            }

            1 -> {
                binding.housongBackground.setBackgroundResource(R.mipmap.frame320)
            }

            2 -> {
                binding.housongBackground.setBackgroundResource(R.mipmap.frame318)
            }

            3 -> {
                val intent = Intent()
                intent.setClass(this, HouSongTaskActivity::class.java)
                startActivity(intent)
            }
        }

    }
}