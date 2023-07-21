package com.zyl.mobilehospitalhis.ui

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.zyl.mobilehospitalhis.adapter.CheckListAdapter
import com.zyl.mobilehospitalhis.base.BaseActivity
import com.zyl.mobilehospitalhis.bean.HISBean
import com.zyl.mobilehospitalhis.databinding.AcvitityCheckListBinding

class CheckListCacheActivity : BaseActivity() {

    private lateinit var binding: AcvitityCheckListBinding

    private lateinit var adapter: CheckListAdapter

    private var listItems: MutableList<HISBean> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = AcvitityCheckListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnBack.setOnClickListener {
            finish()
        }
        binding.btnSave.visibility = View.VISIBLE
        binding.btnSave.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setMessage("上传选中记录?")
            //点击对话框以外的区域是否让对话框消失
            builder.setCancelable(false)
            //设置正面按钮
            builder.setPositiveButton("确定") { _, _ ->

            }
            val dialog = builder.create()
            //显示对话框
            dialog.show()
        }
        binding.pageTitle.text = "缓存列表"

        adapter = CheckListAdapter({ v -> itemClick(v) }, listItems, true)
        val layoutManager = LinearLayoutManager(this)
        binding.checkListRecyclerView.layoutManager = layoutManager
        binding.checkListRecyclerView.adapter = adapter
        createDatas()
    }

    private fun itemClick(v: HISBean) {
        val intent = Intent()
        intent.setClass(this, CheckFormActivity::class.java)
        intent.putExtra("data",v)
        startActivity(intent)
    }


    @SuppressLint("NotifyDataSetChanged")
    private fun createDatas() {
        var his = HISBean()
        his.serialNo = 0
        his.wristbandNo = "NZX3424561"
        his.name = "刘新韦"
        his.gender = "女"
        his.cardId = "353153199707312234"
        his.age = 22
        his.injuryCate = "轻伤"//伤员分类,轻伤,重伤,死亡
        his.checkCate = "一次检伤"//未检伤,一次检伤,二次检伤
        his.destRoom = "检伤分类组"//去往诊室,收容组,检伤分类组,手术组
        his.checkTime = "2023-07-14 10:19"//检伤时间
        listItems.add(his)

        his = HISBean()
        his.serialNo = 1
        his.wristbandNo = "NZA086157"
        his.name = "张梦梦"
        his.gender = "女"
        his.cardId = "420112197508130109"
        his.age = 27
        his.injuryCate = "中度伤"//伤员分类,轻伤,重伤,死亡
        his.checkCate = "未检伤"//未检伤,一次检伤,二次检伤
        his.destRoom = "检伤分类组"//去往诊室,收容组,检伤分类组,手术组
        his.checkTime = "2023-07-14 12:55"//检伤时间
        listItems.add(his)

        his = HISBean()
        his.serialNo = 1
        his.wristbandNo = "JAA684601"
        his.name = "刘伟"
        his.gender = "男"
        his.cardId = "232330201612121210"
        his.age = 55
        his.injuryCate = "死亡"//伤员分类,轻伤,重伤,死亡
        his.checkCate = "二次检伤"//未检伤,一次检伤,二次检伤
        his.destRoom = "收容组"//去往诊室,收容组,检伤分类组,手术组
        his.checkTime = "2023-07-20 16:27"//检伤时间
        listItems.add(his)

        adapter.notifyDataSetChanged()
    }
}