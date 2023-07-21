package com.zyl.mobilehospitalhos.ui

import android.app.AlertDialog
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import com.zyl.mobilehospitalhos.R
import com.zyl.mobilehospitalhos.base.BaseActivity
import com.zyl.mobilehospitalhos.bean.HISBean
import com.zyl.mobilehospitalhos.databinding.AcvitityCheckFormBinding
import com.zyl.mobilehospitalhos.utils.DateTimePickerUtil

class CheckFormActivity : BaseActivity(), View.OnClickListener {
    private lateinit var binding: AcvitityCheckFormBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = AcvitityCheckFormBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnCheckformSave.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setMessage("保存成功,继续录入?")
            //点击对话框以外的区域是否让对话框消失
            builder.setCancelable(false)
            //设置正面按钮
            builder.setPositiveButton("是的") { _, _ ->

            }
            //设置反面按钮
            builder.setNegativeButton("返回") { _, _ ->
                finish()
            }
            val dialog = builder.create()
            //显示对话框
            dialog.show();
        }
        binding.checkFormChoiceDate.setOnClickListener {
            DateTimePickerUtil().getDateTime(this, binding.checkFormChoiceDate)
        }
        binding.btnBack.setOnClickListener {
            finish()
        }
        binding.baseInfoInputType1.setOnCheckedChangeListener { _, b ->
            if (b) {
                binding.baseInfoInputType2.isChecked = false
                binding.baseInfoInputTypeTv.text = "* 腕带编号（必填）"
                binding.baseInfoInputType1Edt.visibility = View.VISIBLE
                binding.baseInfoInputType2Ibtn.visibility = View.GONE
            }
        }
        binding.baseInfoInputType2.setOnCheckedChangeListener { _, b ->
            if (b) {
                binding.baseInfoInputType1.isChecked = false
                binding.baseInfoInputTypeTv.text = "* 快速建档（必填）"
                binding.baseInfoInputType1Edt.visibility = View.GONE
                binding.baseInfoInputType2Ibtn.visibility = View.VISIBLE
            }
        }
        binding.injuryCate1.setOnClickListener(this)
        binding.injuryCate2.setOnClickListener(this)
        binding.injuryCate3.setOnClickListener(this)
        binding.injuryCate5.setOnClickListener(this)
        setData()
    }

    private fun setData() {
        if (intent.extras?.get("data") != null) {
            var hisBean = intent.extras?.get("data") as HISBean
            if (hisBean != null) {
                binding.checkFormWristbandNo.setText(hisBean.wristbandNo)
                binding.checkFormName.setText(hisBean.name)
                binding.checkFormIdCard.setText(hisBean.cardId)
                binding.checkFormAge.setText(hisBean.age.toString())
                if (hisBean.gender == "男") {
                    binding.checkFormGender1.isChecked = true
                    binding.checkFormGender2.isChecked = false
                } else {
                    binding.checkFormGender1.isChecked = false
                    binding.checkFormGender2.isChecked = true
                }
                binding.checkFormChoiceDate.text = hisBean.checkCate
                when (hisBean.injuryCate) {
                    "轻伤" -> {
                        binding.injuryCate1.background =
                            resources.getDrawable(R.drawable.oval_fill_f2f2f2)
                        binding.injuryCate2.background =
                            resources.getDrawable(R.drawable.oval_fill_ffffff)
                        binding.injuryCate3.background =
                            resources.getDrawable(R.drawable.oval_fill_ffffff)
                        binding.injuryCate5.background =
                            resources.getDrawable(R.drawable.oval_fill_ffffff)
                    }

                    "中度伤" -> {
                        binding.injuryCate1.background =
                            resources.getDrawable(R.drawable.oval_fill_ffffff)
                        binding.injuryCate2.background =
                            resources.getDrawable(R.drawable.oval_fill_f2f2f2)
                        binding.injuryCate3.background =
                            resources.getDrawable(R.drawable.oval_fill_ffffff)
                        binding.injuryCate5.background =
                            resources.getDrawable(R.drawable.oval_fill_ffffff)
                    }

                    "重伤" -> {
                        binding.injuryCate1.background =
                            resources.getDrawable(R.drawable.oval_fill_ffffff)
                        binding.injuryCate2.background =
                            resources.getDrawable(R.drawable.oval_fill_ffffff)
                        binding.injuryCate3.background =
                            resources.getDrawable(R.drawable.oval_fill_f2f2f2)
                        binding.injuryCate5.background =
                            resources.getDrawable(R.drawable.oval_fill_ffffff)
                    }

                    "死亡" -> {
                        binding.injuryCate1.background =
                            resources.getDrawable(R.drawable.oval_fill_ffffff)
                        binding.injuryCate2.background =
                            resources.getDrawable(R.drawable.oval_fill_ffffff)
                        binding.injuryCate3.background =
                            resources.getDrawable(R.drawable.oval_fill_ffffff)
                        binding.injuryCate5.background =
                            resources.getDrawable(R.drawable.oval_fill_f2f2f2)
                    }
                }
            }
        }
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.injuryCate1 -> {
                binding.injuryCate1.background = resources.getDrawable(R.drawable.oval_fill_f2f2f2)
                binding.injuryCate2.background = resources.getDrawable(R.drawable.oval_fill_ffffff)
                binding.injuryCate3.background = resources.getDrawable(R.drawable.oval_fill_ffffff)
                binding.injuryCate5.background = resources.getDrawable(R.drawable.oval_fill_ffffff)
            }

            R.id.injuryCate2 -> {
                binding.injuryCate1.background = resources.getDrawable(R.drawable.oval_fill_ffffff)
                binding.injuryCate2.background = resources.getDrawable(R.drawable.oval_fill_f2f2f2)
                binding.injuryCate3.background = resources.getDrawable(R.drawable.oval_fill_ffffff)
                binding.injuryCate5.background = resources.getDrawable(R.drawable.oval_fill_ffffff)
            }

            R.id.injuryCate3 -> {
                binding.injuryCate1.background = resources.getDrawable(R.drawable.oval_fill_ffffff)
                binding.injuryCate2.background = resources.getDrawable(R.drawable.oval_fill_ffffff)
                binding.injuryCate3.background = resources.getDrawable(R.drawable.oval_fill_f2f2f2)
                binding.injuryCate5.background = resources.getDrawable(R.drawable.oval_fill_ffffff)
            }

            R.id.injuryCate5 -> {
                binding.injuryCate1.background = resources.getDrawable(R.drawable.oval_fill_ffffff)
                binding.injuryCate2.background = resources.getDrawable(R.drawable.oval_fill_ffffff)
                binding.injuryCate3.background = resources.getDrawable(R.drawable.oval_fill_ffffff)
                binding.injuryCate5.background = resources.getDrawable(R.drawable.oval_fill_f2f2f2)
            }

        }
    }

}