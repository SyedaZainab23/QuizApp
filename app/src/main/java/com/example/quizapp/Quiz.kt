package com.example.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.quiz.*
import kotlin.random.Random as Random

class Quiz : AppCompatActivity(), View.OnClickListener {
    private var mCurrentPosition: Int = 1 // Default and the first question position
    private var mQuestionsList: ArrayList<Question>? = null
    private lateinit var mediaPlayer: MediaPlayer
    private var mSelectedOptionPosition: Int = 0
    private var mCorrectAnswers: Int = 0

    private var color = getColor()

    private fun getColor(): Int {
        return (Math.random() * 16777215).toInt() or (0xFF shl 24)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        //This call the parent constructor
        super.onCreate(savedInstanceState)
        mediaPlayer = MediaPlayer.create(this, R.raw.background_music)

        // Start playing the audio
        mediaPlayer.start()

        // Set the audio to play continuously
        mediaPlayer.isLooping = true
        // This is used to align the xml view to this class
        setContentView(R.layout.quiz)
        val activityView = this.findViewById<ScrollView>(R.id.GameLayout)
        activityView.setBackgroundColor(getColor())




        // TODO (STEP 4: Get the NAME from intent and assign it the variable.)
        // START
        // END

        synchronized(this) {

            mQuestionsList = Generate.getQuestions()

            setQuestion()
        }
        tv_option_one.setOnClickListener(this)
        tv_option_two.setOnClickListener(this)
        tv_option_three.setOnClickListener(this)
        tv_option_four.setOnClickListener(this)
        btn_submit.setOnClickListener(this)
        // Initialize the media player and set the audio file
//        mediaPlayer = MediaPlayer.create(this, R.raw.background_music)
//
//        // Start playing the audio
//        mediaPlayer.start()
//
//        // Set the audio to play continuously
//        mediaPlayer.isLooping = true
}




    override fun onClick(v: View?) {



        //val color = Color.argb(255, Random.nextInt(256), Random.nextInt(256), Random.nextInt(256))
        //v?.setBackgroundColor(Color.RED)
//        val RandomColor= mapOf("RED" to 1,"BLUE" to 2,"PINK" to 3, "YELLOW" to 4)
//
//        val numbers = (1..4).toList()
//        val randomNumbers = numbers.shuffled().take(1)


        when (v?.id) {

            R.id.tv_option_one -> {

                selectedOptionView(tv_option_one, 1)
            }

            R.id.tv_option_two -> {

                selectedOptionView(tv_option_two, 2)
            }

            R.id.tv_option_three -> {

                selectedOptionView(tv_option_three, 3)
            }

            R.id.tv_option_four -> {

                selectedOptionView(tv_option_four, 4)
            }

            R.id.btn_submit -> {



                if (mSelectedOptionPosition == 0) {

                    mCurrentPosition++

                    when {

                        mCurrentPosition <= mQuestionsList!!.size -> {

                            setQuestion()
                            val color = getColor()
                            val view = this.findViewById<ScrollView>(R.id.GameLayout)
                            view.setBackgroundColor(color)

                        }
                        else -> {

                            // TODO (STEP 5: Now remove the toast message and launch the result screen which we have created and also pass the user name and score details to it.)
                            // START
                            val intent =
                                Intent(this@Quiz, Result::class.java)
                            intent.putExtra(Generate.CORRECT_ANSWERS, mCorrectAnswers)
                            intent.putExtra(Generate.TOTAL_QUESTIONS, mQuestionsList!!.size)
                            startActivity(intent)
                            finish()
                            // END
                        }
                    }
                } else {
                    val question = mQuestionsList?.get(mCurrentPosition - 1)

                    // This is to check if the answer is wrong
                    if (question!!.correctAnswer != mSelectedOptionPosition) {
                        answerView(mSelectedOptionPosition, R.drawable.wrong_option_border_bg)
                    }
                    else {
                        mCorrectAnswers++
                    }

                    // This is for correct answer
                    answerView(question.correctAnswer, R.drawable.correct_option_border_bg)

                    if (mCurrentPosition == mQuestionsList!!.size) {
                        btn_submit.text = "FINISH"
                    } else {
                        btn_submit.text = "GO TO NEXT QUESTION"


                    }

                    mSelectedOptionPosition = 0
                }
            }
        }
    }

    /**
     * A function for setting the question to UI components.
     */
    private fun setQuestion() {

//        val ll=findViewById<LinearLayout>(R.id.quizlayout)
        val ll=findViewById<LinearLayout>(R.id.quizlayout)
        val RandomColor= mapOf(0 to "PURPLE", 1 to "RED",2 to "BLUE",3 to "YELLOW",4 to "CYAN", 5 to "GRAY", 6 to "GREEN", 7 to "MAGENTA", 8 to "TRANSPARENT")
        val list = listOf(1, 2, 3, 4, 5, 6, 7, 8)
        val randomIndex = Random.nextInt(list.size);
        val randomElement:String = RandomColor[randomIndex].toString()
        Log.d("QUIZ", "Color is $randomElement")
        ll.setBackgroundColor(Color.parseColor(randomElement))

        val question = mQuestionsList!!.get(mCurrentPosition - 1) // Getting the question from the list with the help of current position.

        defaultOptionsView()

        if (mCurrentPosition == mQuestionsList!!.size) {
            btn_submit.text = "FINISH"
        } else {
            btn_submit.text = "SUBMIT"
        }

        progressBar.progress = mCurrentPosition
        tv_progress.text = "$mCurrentPosition" + "/" + progressBar.getMax()

        tv_question.text = question.question
        iv_image.setImageResource(question.image)
        tv_option_one.text = question.optionOne
        tv_option_two.text = question.optionTwo
        tv_option_three.text = question.optionThree
        tv_option_four.text = question.optionFour
    }

    /**
     * A function to set the view of selected option view.
     */
    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int) {

        defaultOptionsView()

        mSelectedOptionPosition = selectedOptionNum

        tv.setTextColor(
            Color.parseColor("#363A43")
        )
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this@Quiz,
            R.drawable.selected_option_border_bg
        )
    }

    /**
     * A function to set default options view when the new question is loaded or when the answer is reselected.
     */
    private fun defaultOptionsView() {

        val options = ArrayList<TextView>()
        options.add(0, tv_option_one)
        options.add(1, tv_option_two)
        options.add(2, tv_option_three)
        options.add(3, tv_option_four)

        for (option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this@Quiz,
                R.drawable.default_option_border_bg
            )
        }
    }

    /**
     * A function for answer view which is used to highlight the answer is wrong or right.
     */
    private fun answerView(answer: Int, drawableView: Int) {

        when (answer) {

            1 -> {
                tv_option_one.background = ContextCompat.getDrawable(
                    this@Quiz,
                    drawableView
                )
            }
            2 -> {
                tv_option_two.background = ContextCompat.getDrawable(
                    this@Quiz,
                    drawableView
                )
            }
            3 -> {
                tv_option_three.background = ContextCompat.getDrawable(
                    this@Quiz,
                    drawableView
                )
            }
            4 -> {
                tv_option_four.background = ContextCompat.getDrawable(
                    this@Quiz,
                    drawableView
                )
            }
        }
    }
    override fun onPause() {
        super.onPause()
        mediaPlayer.pause()
    }

    override fun onResume() {
        super.onResume()
        mediaPlayer.start()
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.release()
    }

}