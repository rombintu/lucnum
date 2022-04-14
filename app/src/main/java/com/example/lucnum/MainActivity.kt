package com.example.lucnum

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.text.ParseException
import java.text.SimpleDateFormat

fun validateDate(date: String): Boolean {
    if (date == "") {
        return false
    }

    var format = SimpleDateFormat("dd.MM.yy")
    try {
        format.parse(date)
    } catch (e: ParseException) {
        return false
    }
    return true
}


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btnSubmit = findViewById(R.id.btnGo) as Button
        var dt = findViewById(R.id.editTextDate2) as EditText

        btnSubmit.setOnClickListener {
            var datetime: String = dt.text.toString()

            if (!validateDate(datetime)) {
                Toast.makeText(applicationContext, "Пример: 01.01.1999", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val intent = Intent(this, CompiledActivity::class.java).apply {
                putExtra("context", datetime)
            }
            startActivity(intent)
        }
    }
}