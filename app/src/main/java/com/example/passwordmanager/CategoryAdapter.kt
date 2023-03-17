package com.example.passwordmanager

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.realm.RealmResults

class CategoryAdapter(realmResults: RealmResults<MyModel>):RecyclerView.Adapter<ViewHolderCategory>() {
    private val rResults:RealmResults<MyModel> =realmResults
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderCategory {
        val  oneXml = LayoutInflater.from(parent.context)
            .inflate(R.layout.category_layout,parent,false)
        return ViewHolderCategory(oneXml)
    }

    override fun getItemCount(): Int {
        return rResults.size
    }

    override fun onBindViewHolder(holder: ViewHolderCategory, position: Int) {
        val myModel = rResults[position]//position番目の結果を取得
        holder.tvCategory.text = myModel?.category.toString() //position番目のnameを代入
    }
}