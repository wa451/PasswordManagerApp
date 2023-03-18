package com.example.passwordmanager

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ViewHolderShow(v: View): RecyclerView.ViewHolder(v) {
    var showName1 = v.findViewById<TextView>(R.id.showName1)
    var showPass1 = v.findViewById<TextView>(R.id.showPass1)
    var showName2 = v.findViewById<TextView>(R.id.showName2)
    var showPass2 = v.findViewById<TextView>(R.id.showPass2)
    var showName3 = v.findViewById<TextView>(R.id.showName3)
    var showPass3 = v.findViewById<TextView>(R.id.showPass3)
    var showName4 = v.findViewById<TextView>(R.id.showName4)
    var showPass4 = v.findViewById<TextView>(R.id.showPass4)
    var showName5 = v.findViewById<TextView>(R.id.showName5)
    var showPass5 = v.findViewById<TextView>(R.id.showPass5)
    var showName6 = v.findViewById<TextView>(R.id.showName6)
    var showPass6 = v.findViewById<TextView>(R.id.showPass6)

}