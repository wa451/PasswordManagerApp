package com.example.passwordmanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class EditActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)

        val etCategory: EditText = findViewById(R.id.etCategory)
        val etTitle: EditText = findViewById(R.id.etTitle)
        val btnSave: Button = findViewById(R.id.btnSave)
        val btnAdd:Button = findViewById(R.id.btnAdd)
    }
}