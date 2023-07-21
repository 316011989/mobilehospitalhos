package com.zyl.mobilehospitalhis.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.zyl.mobilehospitalhis.R
import com.zyl.mobilehospitalhis.bean.HISBean
import com.zyl.mobilehospitalhis.databinding.HisListItemBinding


/**
 * 适配器
 */
private const val TAG = "CheckListAdapter"

class CheckListAdapter(
    private val itemClickedListener: (HISBean) -> Unit,
    private val list: List<HISBean>?,
    private val isCache: Boolean,
) : RecyclerView.Adapter<CheckListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            HisListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list!![position]
        holder.wristbandNo.text = item.wristbandNo
        holder.name.text = item.name
        holder.gender.text = item.gender
        holder.cardId.text = item.cardId
        holder.age.text = item.age.toString()
        holder.injuryCate.text = item.injuryCate
        when (item.injuryCate) {
            "重伤" -> {
                holder.injuryCate.setBackgroundColor(
                    ContextCompat.getColor(
                        holder.itemView.context,
                        R.color.red
                    )
                )
            }

            "轻伤" -> {
                holder.injuryCate.setBackgroundColor(
                    ContextCompat.getColor(
                        holder.itemView.context,
                        R.color.ccp_green_alpha
                    )
                )
            }

            "中度伤" -> {
                holder.injuryCate.setBackgroundColor(
                    ContextCompat.getColor(
                        holder.itemView.context,
                        R.color.darkorange
                    )
                )
            }

            "死亡" -> {
                holder.injuryCate.setBackgroundColor(
                    ContextCompat.getColor(
                        holder.itemView.context,
                        R.color.gray_qian
                    )
                )
            }
        }
        holder.checkCate.text = item.checkCate
        holder.destRoom.text = item.destRoom
        holder.checkTime.text = item.checkTime
        if (isCache)
            holder.itemChoose.visibility = View.VISIBLE
        else
            holder.itemChoose.visibility = View.INVISIBLE

        holder.item = item

    }


    override fun getItemCount(): Int = list?.size ?: 0

    inner class ViewHolder(
        binding: HisListItemBinding,
    ) :
        RecyclerView.ViewHolder(binding.root) {
        val wristbandNo: TextView = binding.checkItemWristbandNo
        var name: TextView = binding.checkItemName
        var gender: TextView = binding.checkItemGender
        var cardId: TextView = binding.checkItemIdcard
        var age: TextView = binding.checkItemAge
        var injuryCate: TextView = binding.checkItemInjuryCate
        var checkCate: TextView = binding.checkItemCheckCate
        var destRoom: TextView = binding.checkItemDestRoom
        var checkTime: TextView = binding.checkItemCheckTime
        var itemChoose: CheckBox = binding.itemChoose

        var item: HISBean? = null

        init {
            binding.root.setOnClickListener {
                item?.let {
                    itemClickedListener(it)
                }
            }
        }
    }
}
