package com.example.passwordmanager

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import io.realm.Realm
import io.realm.Sort

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var realm: Realm
    private lateinit var categoryAdapter: CategoryAdapter
    private lateinit var layoutManager: LayoutManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnNew: Button = findViewById(R.id.btnNew)
        realm= Realm.getDefaultInstance()

        btnNew.setOnClickListener {
            val intent = Intent(this,EditActivity::class.java)
            startActivity(intent)
        }
    }
    override fun onStart() {
        super.onStart()
        val uniqueCategory = realm.where(MyModel::class.java).distinct("category").findAll().sort("category", Sort.ASCENDING)
        //アダプターに結果を入れますよ
        recyclerView = findViewById(R.id.rvMain)//ここでまずは中身recyclerViewにを入れる
        categoryAdapter = CategoryAdapter(uniqueCategory)
        recyclerView.adapter = categoryAdapter

        //縦並びに配置しますよ
        layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
    }
    override fun onDestroy() {
        super.onDestroy()
        realm.close()
    }
}