package com.example.passwordmanager

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.realm.Realm
import io.realm.kotlin.where

class ShowActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var realm: Realm
    private lateinit var showAdapter: ShowAdapter
    private lateinit var layoutManager: RecyclerView.LayoutManager
    var id = 0L

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
//                val deleteDialog = DeleteDialog(id)
//                deleteDialog.show(supportFragmentManager, "DeleteDialog")
                AlertDialog.Builder(this)
                    .setMessage(R.string.confirm)
                    .setPositiveButton(R.string.yes,
                        DialogInterface.OnClickListener { dialog, id ->
                            realm = Realm.getDefaultInstance()
                            realm.executeTransaction {
                                //一致するidを探して、delete
                                realm.where<MyModel>()
                                    .equalTo("id", this.id)
                                    .findFirst()?.deleteFromRealm()
                            }
                            finish()
                        })
                    .setNegativeButton(R.string.no,
                        DialogInterface.OnClickListener { dialog, id ->

                        })
                    .show()
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