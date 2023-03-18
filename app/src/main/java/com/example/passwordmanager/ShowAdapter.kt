package com.example.passwordmanager

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.realm.RealmResults

class ShowAdapter(realmResults: RealmResults<MyModel>): RecyclerView.Adapter<ViewHolderShow>() {
    private val rResults: RealmResults<MyModel> =realmResults
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderShow {
        val  oneXml = LayoutInflater.from(parent.context)
            .inflate(R.layout.show_layout,parent,false)
        return ViewHolderShow(oneXml)
    }

    override fun getItemCount(): Int {
        return rResults.size
    }

    override fun onBindViewHolder(holder: ViewHolderShow, position: Int) {
        val myModel = rResults[position]//position番目の結果を取得
        val tvName = listOf(holder.showName1, holder.showName2, holder.showName3, holder.showName4, holder.showName5, holder.showName6)
        val tvPass = listOf(holder.showPass1, holder.showPass2, holder.showPass3, holder.showPass4, holder.showPass5, holder.showPass6)
        val nameList = listOf(myModel?.name1.toString(), myModel?.name2.toString(), myModel?.name3.toString(), myModel?.name4.toString(), myModel?.name5.toString(), myModel?.name6.toString())
        val passList = listOf(myModel?.password1.toString(), myModel?.password2.toString(), myModel?.password3.toString(), myModel?.password4.toString(), myModel?.password5.toString(), myModel?.password6.toString())
        for (i in 0..tvName.size-1){
            if (nameList[i] == ""){
                tvName[i].text = ""
                tvPass[i].text = ""
            }else {
                tvName[i].text = nameList[i]
                tvPass[i].text = passList[i]
            }
        }
    }
}