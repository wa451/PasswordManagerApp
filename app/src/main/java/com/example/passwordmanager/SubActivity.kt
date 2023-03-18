package com.example.passwordmanager

import android.icu.text.CaseMap.Title
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.realm.Realm
import io.realm.Sort

class SubActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var realm: Realm
    private lateinit var titleAdapter: TitleAdapter
    private lateinit var layoutManager: RecyclerView.LayoutManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)

        realm= Realm.getDefaultInstance()
    }

    override fun onStart() {
        super.onStart()

        var category = intent.getStringExtra("category").toString()

        val uniqueTitle = realm.where(MyModel::class.java).equalTo("category", category).findAll().sort("category", Sort.ASCENDING)

        //アダプターに結果を入れますよ
        recyclerView = findViewById(R.id.rvSub)//ここでまずは中身recyclerViewにを入れる
        titleAdapter = TitleAdapter(uniqueTitle)
        recyclerView.adapter = titleAdapter

        //縦並びに配置しますよ
        layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
    }

    override fun onDestroy() {
        super.onDestroy()
        realm.close()
    }
}