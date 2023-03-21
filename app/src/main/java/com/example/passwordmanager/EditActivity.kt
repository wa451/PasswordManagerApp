package com.example.passwordmanager

import android.os.Bundle
import android.util.TypedValue
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import io.realm.Realm
import io.realm.kotlin.createObject
import io.realm.kotlin.where


class EditActivity : AppCompatActivity() {
    private lateinit var realm: Realm
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)

        val etCategory: TextView = findViewById(R.id.etCategory)
        val etTitle: TextView = findViewById(R.id.etTitle)
        val etName1: TextView = findViewById(R.id.etName1)
        val etPass1: TextView = findViewById(R.id.etPass1)
        val etName2: TextView = findViewById(R.id.etName2)
        val etPass2: TextView = findViewById(R.id.etPass2)
        val etName3: TextView = findViewById(R.id.etName3)
        val etPass3: TextView = findViewById(R.id.etPass3)
        val etName4: TextView = findViewById(R.id.etName4)
        val etPass4: TextView = findViewById(R.id.etPass4)
        val etName5: TextView = findViewById(R.id.etName5)
        val etPass5: TextView = findViewById(R.id.etPass5)
        val etName6: TextView = findViewById(R.id.etName6)
        val etPass6: TextView = findViewById(R.id.etPass6)
        val btnSave: Button = findViewById(R.id.btnSave)

        val getId = intent.getLongExtra("ID",0L)
        realm= Realm.getDefaultInstance()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        if(getId>0){
            //既存のレコードが存在するので、一致するidを取得（して表示）
            val myModelResult = realm.where<MyModel>()
                .equalTo("id",getId).findFirst()
            etCategory.text = myModelResult?.category.toString()
            etTitle.text = myModelResult?.title.toString()
            etName1.text = myModelResult?.name1.toString()
            etPass1.text = myModelResult?.password1.toString()
            etName2.text = myModelResult?.name2.toString()
            etPass2.text = myModelResult?.password2.toString()
            etName3.text = myModelResult?.name3.toString()
            etPass3.text = myModelResult?.password3.toString()
        }

        btnSave.setOnClickListener {
            //上書き用の変数を用意
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

            //１０）入力された文字が空文字でなければ～(変数に代入）
            if(!etCategory.text.isNullOrEmpty() and !etTitle.text.isNullOrEmpty()){
                category =etCategory.text.toString()
                title=etTitle.text.toString()
                name1 = etName1.text.toString()
                password1 = etPass1.text.toString()
                name2 = etName2.text.toString()
                password2 = etPass2.text.toString()
                name3 = etName3.text.toString()
                password3 = etPass3.text.toString()
                name4 = etName4.text.toString()
                password4 = etPass4.text.toString()
                name5 = etName5.text.toString()
                password5 = etPass5.text.toString()
                name6 = etName6.text.toString()
                password6 = etPass6.text.toString()

            }
//            val nameList = listOf(name1, name2, name3, name4, name5, name6)
//            val passwordList = listOf(password1, password2, password3, password4, password5, password6)

            if (getId == 0L){
                realm.executeTransaction {
                    val currentId = realm.where<MyModel>().max("id")//現時点のid(の最高値)を取得
                    val nextId =(currentId?.toLong() ?:0L)+1L //最高値に１を追加（最高値が０なら１に）←行を追加するイメージ
                    //モデルクラス(nextId番目)に値をセット
                    val myModel =realm.createObject<MyModel>(nextId)
                    myModel.category = category
                    myModel.title = title
                    myModel.name1 = name1
                    myModel.password1 = password1
                    myModel.name2 = name2
                    myModel.password2 = password2
                    myModel.name3 = name3
                    myModel.password3 = password3
                    myModel.name4 = name4
                    myModel.password4 = password4
                    myModel.name5 = name5
                    myModel.password5 = password5
                    myModel.name6 = name6
                    myModel.password6 = password6
                }
            }else{
                realm.executeTransaction {
                    val myModel = realm.where<MyModel>()
                        .equalTo("id",getId).findFirst()
                    myModel?.category = category
                    myModel?.title = title
                    myModel?.name1 = name1
                    myModel?.password1 = password1
                    myModel?.name2 = name2
                    myModel?.password2 = password2
                    myModel?.name3 = name3
                    myModel?.password3 = password3
                    myModel?.name4 = name4
                    myModel?.password4 = password4
                    myModel?.name5 = name5
                    myModel?.password5 = password5
                    myModel?.name6 = name6
                    myModel?.password6 = password6
                }
            }


            Toast.makeText(applicationContext,"保存しました",Toast.LENGTH_SHORT).show()
            finish()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home){
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
    override fun onDestroy() {
        super.onDestroy()
        realm.close()
    }
    private fun Int.dpToPx(): Int {
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            this.toFloat(),
            resources.displayMetrics
        ).toInt()
    }
}