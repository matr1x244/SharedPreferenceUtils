package com.example.sharedpreferenceutils

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var editText: EditText
    lateinit var btnSave: Button
    lateinit var btnOpen: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText = findViewById(R.id.edit_text)
        btnSave = findViewById(R.id.button_save)
        btnOpen = findViewById(R.id.button_open_save)

        val sharedPreference: SharedPreference = SharedPreference(this)

        btnSave.setOnClickListener {
            val edit = editText.editableText.toString()

            sharedPreference.save("edit", edit)
        }

        btnOpen.setOnClickListener {
            if(sharedPreference.getValueString("edit") != null){
                editText.hint = sharedPreference.getValueString("edit")
            } else {
                editText.hint = "Ни чего не сохранено"
            }
        }
    }
}