package com.zyl.mobilehospitalhos.bean

import java.io.Serializable

class HISBean:Serializable {
    var serialNo: Int? = null
    var wristbandNo: String? = null
    var name: String? = null
    var gender: String? = null
    var cardId: String? = null//身份证
    var age: Int? = null
    var injuryCate: String? = null//伤员分类,轻伤,重伤,死亡
    var checkCate: String? = null//未检伤,一次检伤,二次检伤
    var destRoom: String? = null//去往诊室,收容组,检伤分类组,手术组
    var checkTime: String? = null//检伤时间
}
