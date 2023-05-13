package com.example.bodyshody

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar

class ExerciseActivity : AppCompatActivity() {
    lateinit var exerciseToolbar:Toolbar
    lateinit var progressBar: ProgressBar
    lateinit var timerTV: TextView
    private var restTimer: CountDownTimer? = null
    private var restProgress = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise)
        exerciseToolbar = findViewById(R.id.exercise_toolbar)
        progressBar = findViewById(R.id.progressBar)
        timerTV = findViewById(R.id.timerTV)
        setSupportActionBar(exerciseToolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        exerciseToolbar.setNavigationOnClickListener {
            onBackPressed()
        }

        setRestProgressBar()
    }

    private fun setRestProgressBar(){
        progressBar.progress = restProgress
        restTimer = object: CountDownTimer(10000,1000){
            override fun onTick(millisUntilFinished: Long) {//On every One second ,countDownInterval
                restProgress++
                progressBar.progress = 10 - restProgress
                timerTV.text = (10 - restProgress).toString()
            }
            override fun onFinish() {
                Toast.makeText(this@ExerciseActivity,"Starting Exercise",Toast.LENGTH_SHORT).show()
            }
        }.start()
    }

    override fun onDestroy() {
        super.onDestroy()
        if(restTimer!=null){
            restTimer!!.cancel()
            restProgress = 0
        }

    }
}