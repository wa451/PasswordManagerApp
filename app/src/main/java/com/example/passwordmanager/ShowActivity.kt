package com.example.passwordmanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.realm.Realm
import io.realm.Sort

class ShowActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var realm: Realm
    private lateinit var showAdapter: ShowAdapter
    private lateinit var layoutManager: RecyclerView.LayoutManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show)

        realm= Realm.getDefaultInstance()
    }

    override fun onStart() {
        super.onStart()

        var title = intent.getStringExtra("title").toString()

        val uniqueList = realm.where(MyModel::class.java).equalTo("title", title).findAll()

        //アダプターに結果を入れますよ
        recyclerView = findViewById(R.id.rvShow)//ここでまずは中身recyclerViewにを入れる
        showAdapter = ShowAdapter(uniqueList)
        recyclerView.adapter = showAdapter

        //縦並びに配置しますよ
        layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
    }

    override fun onDestroy() {
        super.onDestroy()
        realm.close()
    }
}