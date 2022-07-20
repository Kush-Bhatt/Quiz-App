package com.example.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat

class QuizQuestionsActivity : AppCompatActivity() ,View.OnClickListener{

    private var mCurrentPosition  : Int = 0
    private var mQuestionList  : ArrayList<Question>? = null
    private var mSelectedOptionPosition  : Int = 0
    private var mCorrectAnswer : Int = 0
    private var mUsername : String? = null

    lateinit var progressBar : ProgressBar
    lateinit var tv_progress : TextView
    lateinit var tv_question : TextView
    lateinit var iv_image : ImageView
    lateinit var tv_option_one : TextView
    lateinit var tv_option_two : TextView
    lateinit var tv_option_third : TextView
    lateinit var tv_option_four : TextView
    lateinit var btn_submit : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        mUsername = intent.getStringExtra(Constants.USER_NAME)

        progressBar = findViewById<ProgressBar>(R.id.progressBar)
        tv_progress = findViewById<TextView>(R.id.tv_progressBar)
        tv_question = findViewById<TextView>(R.id.tv_question)
        iv_image = findViewById<ImageView>(R.id.iv_image)
        tv_option_one = findViewById<TextView>(R.id.tv_option_one)
        tv_option_two = findViewById<TextView>(R.id.tv_option_two)
        tv_option_third = findViewById<TextView>(R.id.tv_option_third)
        tv_option_four = findViewById<TextView>(R.id.tv_option_four)
        btn_submit = findViewById<Button>(R.id.btn_submit)

        mQuestionList = Constants.getQuestions()
        //Log.i("Question Size","${questionList.size}")

        updateQuestion()

        tv_option_one.setOnClickListener(this)
        tv_option_two.setOnClickListener(this)
        tv_option_third.setOnClickListener(this)
        tv_option_four.setOnClickListener(this)
        btn_submit.setOnClickListener(this)

    }

    private fun updateQuestion(){

        defaultOptionsView()  //Each time we set the question we set the default ui for each question
        mCurrentPosition++

        if(mCurrentPosition == mQuestionList!!.size) {
            btn_submit.text = "FINISH"
        } else{
            btn_submit.text = "SUBMIT"
        }
//        mCurrentPosition = 1
        val question = mQuestionList!![mCurrentPosition - 1]

        progressBar.progress = mCurrentPosition
        tv_progress.text = "${mCurrentPosition}" + "/" + progressBar.max
        tv_question.text = question!!.question
        iv_image.setImageResource(question.image)
        tv_option_one.text = question.optionOne
        tv_option_two.text = question.optionTwo
        tv_option_third.text = question.optionThird
        tv_option_four.text = question.optionFour

    }

    private fun defaultOptionsView()
    {
        val options = ArrayList<TextView>()     //ArrayList of Textview (options)

        options.add(0,tv_option_one)
        options.add(1,tv_option_two)
        options.add(2,tv_option_third)
        options.add(3,tv_option_four)

        for(i in 0..3){
            options[i].setTextColor(Color.parseColor("#7A8089"))
            options[i].typeface = Typeface.DEFAULT
            options[i].background = ContextCompat.getDrawable(
                this,
                R.drawable.default_option_border_bg
            )
        }
    }

    override fun onClick(v: View?) {
            when(v?.id)
            {
                R.id.tv_option_one -> {
                    selectedOptionView(tv_option_one,1)
                }

                R.id.tv_option_two -> {
                    selectedOptionView(tv_option_two,2)
                }

                R.id.tv_option_third -> {
                    selectedOptionView(tv_option_third,3)
                }

                R.id.tv_option_four -> {
                    selectedOptionView(tv_option_four,4)
                }

                R.id.btn_submit -> {
                    if(mSelectedOptionPosition == 0)
                    {
                        if(btn_submit.text.toString() == "SUBMIT")
                        {
                            Toast.makeText(this,"Please select your accordingly option!!",Toast.LENGTH_SHORT).show()
                        } else if(mCurrentPosition < mQuestionList!!.size){
                            updateQuestion()
                        }
                        else{
                            val intent = Intent(this,ResultActivity :: class.java)
                            intent.putExtra(Constants.USER_NAME,mUsername)
                            intent.putExtra(Constants.CORRECT_ANSWERS,mCorrectAnswer)
                            intent.putExtra(Constants.TOTAL_QUESTIONS,mQuestionList!!.size)
                            startActivity(intent)
                            finish()
                        }
                    }

                    else{
//                        val question = mQuestionList?.get(mCurrentPosition - 1)
                        Log.i("CurrentPostion","${mCurrentPosition}")
                        Log.i("OptionList","${mQuestionList!![mCurrentPosition-1]}")

                        if(mQuestionList!![mCurrentPosition-1].correctAnswer != mSelectedOptionPosition)
                        {
                            answerView(mSelectedOptionPosition,R.drawable.incorrect_option_border_bg)
                            Log.i("Wrong","Red color")

                        } else  mCorrectAnswer++

                        answerView(mQuestionList!![mCurrentPosition-1].correctAnswer,R.drawable.correct_option_border_bg)

                        if(mCurrentPosition  == mQuestionList!!.size)
                        {
                            btn_submit.text = "FINISH"
                        } else{
                            btn_submit.text = "Go to Next Question"
                        }

                        mSelectedOptionPosition = 0

                    }
                }
            }
    }

     private fun answerView(answer : Int, drawableView : Int)
     {
         when(answer){
             1 -> {
                 tv_option_one.background = ContextCompat.getDrawable(
                     this,drawableView
                 )
             }

             2 -> {
                 tv_option_two.background = ContextCompat.getDrawable(
                     this,drawableView
                 )
             }

             3 -> {
                 tv_option_third.background = ContextCompat.getDrawable(
                     this,drawableView
                 )
             }

             4 -> {
                 tv_option_four.background = ContextCompat.getDrawable(
                     this,drawableView
                 )
             }
         }
     }

    private fun selectedOptionView(tv : TextView, selectedOptionNum : Int)
    {
        defaultOptionsView()   // reset to default ( if you have selected any one option and you want to select
    // another then the selected one should be dond default again)

        mSelectedOptionPosition = selectedOptionNum

        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this,
            R.drawable.selected_option_border_bg
        )
    }
}