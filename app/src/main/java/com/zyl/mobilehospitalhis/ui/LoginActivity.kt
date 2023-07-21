package com.zyl.mobilehospitalhis.ui

import android.content.Intent
import android.os.Bundle
import com.zyl.mobilehospitalhis.base.BaseActivity
import com.zyl.mobilehospitalhis.databinding.ActivityLoginBinding

class LoginActivity : BaseActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btLoginLogin.setOnClickListener {
            val intent = Intent()
            intent.setClass(this, ChoiceOptActivity::class.java)
            startActivity(intent)
        }
        binding.loginOffline.setOnCheckedChangeListener { _, b ->
            if (b) {
                binding.etLoginUsername.isEnabled = false
                binding.etLoginPwd.isEnabled = false
            } else {
                binding.etLoginUsername.isEnabled = true
                binding.etLoginPwd.isEnabled = true
            }
        }
    }

}