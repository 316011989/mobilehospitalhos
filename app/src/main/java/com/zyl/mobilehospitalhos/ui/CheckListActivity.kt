package com.zyl.mobilehospitalhos.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.zyl.mobilehospitalhos.bean.HISBean
import com.zyl.mobilehospitalhos.adapter.CheckListAdapter
import com.zyl.mobilehospitalhos.base.BaseActivity
import com.zyl.mobilehospitalhos.databinding.AcvitityCheckListBinding

class CheckListActivity : BaseActivity() {
    private lateinit var binding: AcvitityCheckListBinding

    private lateinit var adapter: CheckListAdapter

    private var listItems: MutableList<HISBean> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = AcvitityCheckListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnSave.visibility= View.INVISIBLE
        binding.btnBack.setOnClickListener {
            finish()
        }


        adapter = CheckListAdapter({ v -> itemClick(v) }, listItems,false)
        val layoutManager = LinearLayoutManager(this)
        binding.checkListRecyclerView.layoutManager = layoutManager
        binding.checkListRecyclerView.adapter = adapter
        createDatas()
    }


    private fun itemClick(h: HISBean) {
        val intent = Intent()
        intent.setClass(this, CheckFormActivity::class.java)
        intent.putExtra("data",h)
        startActivity(intent)
    }


    @SuppressLint("NotifyDataSetChanged")
    private fun createDatas() {
        var his = HISBean()
        his.serialNo = 0
        his.wristbandNo = "123456"
        his.name = "张志远"
        his.gender = "男"
        his.cardId = "110111201912120012"
        his.age = 24
        his.injuryCate = "轻伤"//伤员分类,轻伤,重伤,死亡
        his.checkCate = "未检伤"//未检伤,一次检伤,二次检伤
        his.destRoom = "收容组"//去往诊室,收容组,检伤分类组,手术组
        his.checkTime = "2023-07-20 16:19"//检伤时间
        listItems.add(his)

        his = HISBean()
        his.serialNo = 1
        his.wristbandNo = "0001237"
        his.name = "李明志"
        his.gender = "男"
        his.cardId = "420112197508130109"
        his.age = 32
        his.injuryCate = "重伤"//伤员分类,轻伤,重伤,死亡
        his.checkCate = "二次检伤"//未检伤,一次检伤,二次检伤
        his.destRoom = "手术组"//去往诊室,收容组,检伤分类组,手术组
        his.checkTime = "2023-07-20 16:25"//检伤时间
        listItems.add(his)

        his = HISBean()
        his.serialNo = 1
        his.wristbandNo = "6846301"
        his.name = "王宁雪"
        his.gender = "女"
        his.cardId = "232330201612121210"
        his.age = 10
        his.injuryCate = "轻伤"//伤员分类,轻伤,重伤,死亡
        his.checkCate = "一次检伤"//未检伤,一次检伤,二次检伤
        his.destRoom = "检伤分类组"//去往诊室,收容组,检伤分类组,手术组
        his.checkTime = "2023-07-20 16:27"//检伤时间
        listItems.add(his)

        adapter.notifyDataSetChanged()
    }

}