package com.zyl.mobilehospitalhis.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.zyl.mobilehospitalhis.R
import com.zyl.mobilehospitalhis.base.BaseActivity
import com.zyl.mobilehospitalhis.databinding.AcvitityChoiceOptBinding

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
                intent.setClass(this, CheckFormActivity::class.java)
                startActivity(intent)
            }

            R.id.btn_opt2 -> {
                val intent = Intent()
                intent.setClass(this, CheckListActivity::class.java)
                startActivity(intent)
            }

            R.id.btn_opt3 -> {
                val intent = Intent()
                intent.setClass(this, CheckListCacheActivity::class.java)
                startActivity(intent)
            }

            R.id.btn_opt4 -> {
                finish()
            }
        }
    }
}