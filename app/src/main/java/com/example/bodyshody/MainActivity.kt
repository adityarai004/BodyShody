package com.example.bodyshody

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var startLl:LinearLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startLl = findViewById(R.id.startLl)
        startLl.setOnClickListener{
            Toast.makeText(this,"Exercise will start soon!!",Toast.LENGTH_SHORT).show()
            val i:Intent = Intent(this,ExerciseActivity::class.java)
            startActivity(i)
        }
    }
}