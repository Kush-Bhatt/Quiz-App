package com.example.quizapp

object Constants  {

    const val USER_NAME : String = "user_name"
    const val TOTAL_QUESTIONS : String = "total_questionS"
    const val CORRECT_ANSWERS : String = "correct_answers"




    fun getQuestions() : ArrayList<Question>{
        val questionList = java.util.ArrayList<Question>()

        val ques1 = Question(
            1,
            "How old was naruto in the OG Naruto?",
            R.drawable.naruto_ques1,
            "10",
            "12",
            "13",
            "16",
            2
        )
        questionList.add(ques1)

        val ques2 = Question(
            2,
            "By what name naruto called Jiraiya?",
            R.drawable.naruto_ques2,
            "Sensei",
            "Jiraiya Sensei",
            "Grandpa",
            "Pervy Sage",
            4
        )
        questionList.add(ques2)

        val ques3 = Question(
            3,
            "Who was the youngest ninja graduate from the academy?",
            R.drawable.naruto_ques3,
            "Kakashi",
            "Minato",
            "Itachi",
            "Obito",
            3
        )
        questionList.add(ques3)

        val ques4 = Question(
            4,
            "Whose necklace is this?",
            R.drawable.naruto_ques4,
            "Gamamaru",
            "Hashirama Senju",
            "Naruto",
            "Hinata",
            1
        )
        questionList.add(ques4)

        val ques5 = Question(
            5,
            "Which word means female ninja?",
            R.drawable.naruto_ques5,
            "Shinobi",
            "Kunoichi",
            "Skibo",
            "Ninjutsu",
            2
        )
        questionList.add(ques5)

        val ques6 = Question(
            6,
            "Who else has the same ability as Kakashi to create lightning with the hand?",
            R.drawable.naruto_ques6,
            "Kakuzu",
            "Indra",
            "Sasuke",
            "Both",
            4
        )
        questionList.add(ques6)

        val ques7 = Question(
            7,
            "Who attacked village with taking nine tails under control at the time of naruto's birth?",
            R.drawable.naruto_ques7,
            "Obito Uchiha",
            "Madara Uchiha",
            "Itachi Uchiha",
            "Shisui Uchiha",
            1
        )
        questionList.add(ques7)

        val ques8 = Question(
            8,
            "For which jutsu Kakashi helped Naruto to master of and is considered Naruto's own creation?",
            R.drawable.naruto_ques8,
            "One Thousand Years of death",
            "Rasengan",
            "Shadow Clone Justu",
            "Rasen-Shuriken",
            4
        )
        questionList.add(ques8)

        val ques9 = Question(
            9,
            "What was Naruto before becoming Hokage?",
            R.drawable.naruto_ques9,
            "Jonin",
            "Chunin",
            "Genin",
            "Sanin",
            3
        )
        questionList.add(ques9)

        val ques10 = Question(
            10,
            "which mode of Naruto is considered to be the strongest?",
            R.drawable.naruto_ques10,
            "Sage Mode",
            "Nine-Tails Mode",
            "Six Paths Sage Mode",
            "Baryon Mode",
            4
        )
        questionList.add(ques10)

        return questionList
    }

}