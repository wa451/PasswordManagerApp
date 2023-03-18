package com.example.passwordmanager

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ViewHolderTitle(v: View): RecyclerView.ViewHolder(v) {
    var tvTitle: TextView =v.findViewById(R.id.tvTitle)
}