package com.example.passwordmanager

import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ViewHolderShow(v: View): RecyclerView.ViewHolder(v) {
    var showName = v.findViewById<TextView>(R.id.showName)
    var showPass = v.findViewById<TextView>(R.id.showPass)

}