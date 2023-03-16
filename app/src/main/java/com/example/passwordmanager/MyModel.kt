package com.example.passwordmanager

import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class MyModel:RealmObject() {
    @PrimaryKey
    var id:Long =0
    var category:String =""
    var title:String =""
    var items: RealmList<PasswordItem> = RealmList()
}
open class PasswordItem : RealmObject() {
    var name: String = ""
    var password: String = ""
}
//val myModel = MyModel()
//myModel.items.add(PasswordItem(20, "John"))
//myModel.items.add(PasswordItem(25, "Mary"))
//myModel.items.add(PasswordItem(30, "Bob"))
//
//realm.executeTransaction { r ->
//    r.insertOrUpdate(myModel)
//}
