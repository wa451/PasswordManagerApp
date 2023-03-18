package com.example.passwordmanager

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.realm.RealmResults

class TitleAdapter(realmResults: RealmResults<MyModel>): RecyclerView.Adapter<ViewHolderTitle>() {
    private val rResults: RealmResults<MyModel> =realmResults
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderTitle {
        val  oneXml = LayoutInflater.from(parent.context)
            .inflate(R.layout.title_layout,parent,false)
        return ViewHolderTitle(oneXml)
    }

    override fun getItemCount(): Int {
        return rResults.size
    }

    override fun onBindViewHolder(holder: ViewHolderTitle, position: Int) {
        val myModel = rResults[position]//position番目の結果を取得
        holder.tvTitle.text = myModel?.title.toString() //position番目のnameを代入

        holder.itemView.setOnClickListener {
            val intent = Intent(it.context,ShowActivity::class.java) //it はRecyclerViewで定義されたレイアウトView
            intent.putExtra("title",myModel?.title)//idを渡す
            it.context.startActivity(intent)
        }
    }
}