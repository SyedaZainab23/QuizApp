package com.example.quizapp
object Generate {

    // TODO (STEP 1: Create a constant variables which we required in the result screen.)
    // START
    const val TOTAL_QUESTIONS: String = "total_questions"
    const val CORRECT_ANSWERS: String = "correct_answers"
    // END

    fun getQuestions(): ArrayList<Question> {
        val questionsList = ArrayList<Question>()
        // 1
        val que1 = Question(
            1, "What country does this flag belong to?",
            R.drawable.ic_flag_of_argentina,

            "Argentina", "Australia",
            "Armenia", "Austria", 1

        )

        questionsList.add(que1)

        // 2
        val que2 = Question(
            2, "What country does this flag belong to?",
            R.drawable.ic_flag_of_australia,
            "Angola", "Austria",
            "Australia", "Armenia", 3
        )

        questionsList.add(que2)

        // 3
        val que3 = Question(
            3, "What country does this flag belong to?",
            R.drawable.ic_flag_of_brazil,
            "Belarus", "Belize",
            "Brunei", "Brazil", 4
        )

        questionsList.add(que3)

        // 4
        val que4 = Question(
            4, "What country does this flag belong to?",
            R.drawable.ic_flag_of_belgium,
            "Bahamas", "Belgium",
            "Barbados", "Belize", 2
        )

        questionsList.add(que4)

        // 5
        val que5 = Question(
            5, "What country does this flag belong to?",
            R.drawable.ic_flag_of_fiji,
            "Gabon", "France",
            "Fiji", "Finland", 3
        )

        questionsList.add(que5)

        // 6
        val que6 = Question(
            6, "What country does this flag belong to?",
            R.drawable.ic_flag_of_germany,
            "Germany", "Georgia",
            "Greece", "none of these", 1
        )

        questionsList.add(que6)

        // 7
        val que7 = Question(
            7, "What country does this flag belong to?",
            R.drawable.ic_flag_of_denmark,
            "Dominica", "Egypt",
            "Denmark", "Ethiopia", 3
        )

        questionsList.add(que7)

        // 8
        val que8 = Question(
            8, "What country does this flag belong to?",
            R.drawable.ic_flag_of_india,
            "Ireland", "Iran",
            "Hungary", "India", 4
        )

        questionsList.add(que8)

        // 9
        val que9 = Question(
            9, "What country does this flag belong to?",
            R.drawable.ic_flag_of_new_zealand,
            "Australia", "New Zealand",
            "Tuvalu", "United States of America", 2
        )

        questionsList.add(que9)

        // 10
        val que10 = Question(
            10, "What country does this flag belong to?",
            R.drawable.ic_flag_of_kuwait,
            "Kuwait", "Jordan",
            "Sudan", "Palestine", 1
        )

        val que11 =  Question(11,"Who actually drew the sketch of Rose in Titanic?",R.drawable.rose_titanic,
            "Leonardo DiCaprio","Billy Zane","James Cameron","Kathy Bates",3)
        val que12 = Question(12,"Which famous Pulp Fiction scene was filmed backward?",R.drawable.pulpfiction,
        "Vincent and Mia’s dance scene","Mia’s overdose scene","The royale with cheese scene",
        "The Ezekiel 25:17 scene",2)
        val que13=Question(13,"The code in The Matrix comes from what food recipes?",R.drawable.matrix,
        "Sushi recipes","Dumpling recipes","Stir-fry recipes","Pad thai recipes",1)
        val que14=Question(14,"What object was Toy Story’s Woody originally?",R.drawable.woody,
        "A puppet","A ventriloquist dummy","A clown doll","A nesting doll",2)
        val que15=Question(15,"Who did the cat in The Godfather belong to?",R.drawable.godfather,
        "Francis Ford Coppola","Diane Keaton","Al Pachino","No one—the cat was a stray",4)
        val que16=Question(16,"What year was the first Die Hard movie released?",R.drawable.die_hard,
        "1986","1988","1990","1991",2)
        val que17=Question(17,"Which actress has the most Oscar wins?",R.drawable.oscar,
        "Katharine Hepburn","Meryl Streep","Ingrid Bergman","Elizabeth Taylor",1)
        val que18=Question(18,"WHAT IS THE HIGHEST GROSSING MOVIE OF ALL TIME?",R.drawable.moneymovie,
        "Avengers: Endgame","Titanic","Avatar","Gone with the Wind",3)
        val que19=Question(19,"WHAT COLOR PILL DOES NEO TAKE IN THE MATRIX?",R.drawable.pill,
        "Blue","Red","Black","Orange",2)
        val que20= Question(20,"Dracula was filmed in English during the day, and in what other language at night?",
        R.drawable.drac,"German","Swedish","French","Spanish",4)




        questionsList.add(que10)
        questionsList.add(que11)
        questionsList.add(que12)
        questionsList.add(que13)
        questionsList.add(que14)
        questionsList.add(que15)
        questionsList.add(que16)
        questionsList.add(que17)
        questionsList.add(que18)
        questionsList.add(que19)
        questionsList.add(que20)


//        var i:Int=0
//        var x="que"
//        while(i<20)
//        {
//            var no:String=i.toString()
//            questionsList.add(x.plus(no))
//            i++
//            Log.d("GENERATE", "getQuestions: i")
//        }
        synchronized(this)
        {
            val numbers = (0..19).toList()
            val randomNumbers = numbers.shuffled().take(4)
//        val randomQuestions= Collections.synchronizedList(java.util.ArrayList(),Question)
            val randomQuestions = ArrayList<Question>()
            randomQuestions.add(questionsList[randomNumbers[0]])
            randomQuestions.add(questionsList[randomNumbers[1]])
            randomQuestions.add(questionsList[randomNumbers[2]])
            randomQuestions.add(questionsList[randomNumbers[3]])
            return randomQuestions
        }
    }
}