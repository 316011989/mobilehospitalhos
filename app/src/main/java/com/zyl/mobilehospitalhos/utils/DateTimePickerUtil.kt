package com.zyl.mobilehospitalhos.utils

import android.app.AlertDialog
import android.content.Context
import android.view.View
import android.widget.DatePicker
import android.widget.TextView
import android.widget.TimePicker
import com.zyl.mobilehospitalhos.R


class DateTimePickerUtil {
    fun getDateTime(mContext: Context?, textView: TextView) {
        val date_time_picker = View.inflate(mContext, R.layout.dialog_datetime_picker, null)
        val datePicker = date_time_picker.findViewById<View>(R.id.data_picker) as DatePicker
        val timePicker = date_time_picker.findViewById<View>(R.id.timer_picker) as TimePicker
        timePicker.setIs24HourView(true)
        //   Build   DateTimeDialog
        val builder = AlertDialog.Builder(mContext)
        builder.setView(date_time_picker)
        builder.setPositiveButton(R.string.ok) { _, _ ->
            val dateStr =
                datePicker.year.toString() + "-" + datePicker.month + "-" + datePicker.dayOfMonth
            val currentMinute = timePicker.currentMinute
            var curMinute = ""
            curMinute = if (currentMinute < 10) {
                "0$currentMinute"
            } else {
                currentMinute.toString()
            }
            val timeStr = timePicker.currentHour.toString() + ":" + curMinute
            textView.text = "$dateStr  $timeStr"
        }
        builder.show()
    }
}