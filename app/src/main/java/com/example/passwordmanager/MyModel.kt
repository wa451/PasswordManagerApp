package com.example.passwordmanager

import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class MyModel:RealmObject() {
    @PrimaryKey
    var id:Long =0
    var category:String =""
    var title:String =""
    var name1:String =""
    var password1:String =""
    var name2:String =""
    var password2:String =""
    var name3:String =""
    var password3:String =""
    var name4:String =""
    var password4:String =""
    var name5:String =""
    var password5:String =""
    var name6:String =""
    var password6:String =""
}
