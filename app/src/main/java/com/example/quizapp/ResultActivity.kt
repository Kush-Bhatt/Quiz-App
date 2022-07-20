package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val username = intent.getStringExtra(Constants.USER_NAME)
        val totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS,0)
        val correctAnswers = intent.getIntExtra(Constants.CORRECT_ANSWERS,0)

        val tv_name = findViewById<TextView>(R.id.tv_username)
        tv_name.text = username

        val tv_score = findViewById<TextView>(R.id.tv_score)
        tv_score.text = "Your score is $correctAnswers out ot $totalQuestions"

        val tv_ramen = findViewById<TextView>(R.id.tv_ramen)
        if(correctAnswers == totalQuestions)
        {
            tv_ramen.text = "Hurray!!You have won Ichiraku Ramen."
        }
        else{
            tv_ramen.text = "Sorry!! You haven't won Ichiraku Ramen."
        }

        val btn_finish = findViewById<Button>(R.id.btn_finish)

        btn_finish.setOnClickListener{
            startActivity(Intent(this,MainActivity :: class.java))
            finish()
        }
    }
}