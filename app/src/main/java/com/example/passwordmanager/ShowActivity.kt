package com.example.passwordmanager

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.realm.Realm
import io.realm.Sort
import io.realm.kotlin.where

class ShowActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var realm: Realm
    private lateinit var showAdapter: ShowAdapter
    private lateinit var layoutManager: RecyclerView.LayoutManager
    var id = 0L

    //    val nameList: List<String> = listOf()(unique?.name1,unique?.name2, unique?.name3 , unique?.name4, unique?.name5, unique?.name6)
//    val passList: Array<String> = arrayOf(unique?.password1 ?: "" , unique?.password2 ?: "", unique?.password3 ?: "", unique?.password4 ?: "", unique?.password5 ?: "", unique?.password6 ?: "")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show)

        realm= Realm.getDefaultInstance()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onStart() {
        super.onStart()

        var title = intent.getStringExtra("title").toString()
        val unique = realm.where(MyModel::class.java).equalTo("title", title).findFirst()
        id = unique?.id ?: 0L
        val nameList: Array<String> = arrayOf(unique?.name1 ?: "" , unique?.name2 ?: "", unique?.name3 ?: "", unique?.name4 ?: "", unique?.name5 ?: "", unique?.name6 ?: "")
        val passList: Array<String> = arrayOf(unique?.password1 ?: "" , unique?.password2 ?: "", unique?.password3 ?: "", unique?.password4 ?: "", unique?.password5 ?: "", unique?.password6 ?: "")

        recyclerView = findViewById(R.id.rvShow)//ここでまずは中身recyclerViewにを入れる
        showAdapter = ShowAdapter(nameList, passList)
        recyclerView.adapter = showAdapter
        layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home ->
                finish()
            R.id.menuListOptionEdit -> {
                val intent = Intent(this, EditActivity::class.java)
                intent.putExtra("ID", id)
                startActivity(intent)
            }
            R.id.menuListOptionDelete -> {
                realm.executeTransaction {
                    //一致するidを探して、delete
                    realm.where<MyModel>()
                        .equalTo("id", id)
                        .findFirst()?.deleteFromRealm()
                }
                Toast.makeText(applicationContext,"削除しました",Toast.LENGTH_SHORT).show()
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_options_menu_list, menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onDestroy() {
        super.onDestroy()
        realm.close()
    }
}