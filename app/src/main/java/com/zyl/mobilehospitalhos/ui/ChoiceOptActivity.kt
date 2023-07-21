package com.zyl.mobilehospitalhos.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.zyl.mobilehospitalhos.R
import com.zyl.mobilehospitalhos.base.BaseActivity
import com.zyl.mobilehospitalhos.databinding.AcvitityChoiceOptBinding
import com.zyl.mobilehospitalhos.hosui.HouSongManageActivity
import com.zyl.mobilehospitalhos.hosui.HouSongRegistActivity
import com.zyl.mobilehospitalhos.hosui.HouSongTaskActivity

class ChoiceOptActivity : BaseActivity(), View.OnClickListener {
    private lateinit var binding: AcvitityChoiceOptBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = AcvitityChoiceOptBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnOpt1.setOnClickListener(this)
        binding.btnOpt2.setOnClickListener(this)
        binding.btnOpt3.setOnClickListener(this)
        binding.btnOpt4.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when (p0!!.id) {
            R.id.btn_opt1 -> {
                val intent = Intent()
//                intent.setClass(this, CheckFormActivity::class.java)
                intent.setClass(this, HouSongTaskActivity::class.java)
                startActivity(intent)
            }

            R.id.btn_opt2 -> {
                val intent = Intent()
//                intent.setClass(this, CheckListActivity::class.java)
                intent.setClass(this, HouSongRegistActivity::class.java)
                startActivity(intent)
            }

            R.id.btn_opt3 -> {
                val intent = Intent()
//                intent.setClass(this, CheckListCacheActivity::class.java)
                intent.setClass(this, HouSongManageActivity::class.java)
                startActivity(intent)
            }

            R.id.btn_opt4 -> {
                finish()
            }
        }
    }
}