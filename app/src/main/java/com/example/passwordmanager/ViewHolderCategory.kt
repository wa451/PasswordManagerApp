package com.example.passwordmanager

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ViewHolderCategory(v: View): RecyclerView.ViewHolder(v) {
    var tvCategory: TextView =v.findViewById(R.id.tvCategory)
}