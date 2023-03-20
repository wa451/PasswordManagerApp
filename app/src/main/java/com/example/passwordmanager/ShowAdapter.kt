package com.example.passwordmanager

import android.view.*
import androidx.recyclerview.widget.RecyclerView

class ShowAdapter(nameList: Array<String>, passList: Array<String>): RecyclerView.Adapter<ViewHolderShow>() {
    val nameList: Array<String> = nameList
    val passList: Array<String> = passList
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderShow {
        val  oneXml = LayoutInflater.from(parent.context)
            .inflate(R.layout.show_layout,parent,false)
        return ViewHolderShow(oneXml)
    }

    override fun getItemCount(): Int {
        return nameList.size
    }

    override fun onBindViewHolder(holder: ViewHolderShow, position: Int) {
            if (!nameList[position].isNullOrEmpty()){
                holder.showName.text = nameList[position] + " :"
                holder.showPass.text = passList[position]
//                dividers[i].height = 0
            }else {
                holder.showName.text = ""
                holder.showPass.text = ""
            }
    }
}