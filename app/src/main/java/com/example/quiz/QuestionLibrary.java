package com.example.quiz;


public class QuestionLibrary {

    private String mQuestions [] = {
            "Which is a object oriented programing",
            "C program language creator?.",
            "Python program language creator?",
            "Haskell program language creator?."

    };


    private String mChoices [][] = {
            {"c", "Html", "c++"},
            {"Ken Thompson", "Dennis Ritchie", "Robin"},
            {"Ken Thompson", "Guido van Rossum", "Robin"},
            {"Ken Thompson", "Guido van Rossum", " Paul Hudak"}
    };



    private String mCorrectAnswers[] = {"c++", "Dennis Ritchie", "Guido van Rossum", "Paul Hudak"};




    public String getQuestion(int a) {
        String question = mQuestions[a];
        return question;
    }


    public String getChoice1(int a) {
        String choice0 = mChoices[a][0];
        return choice0;
    }


    public String getChoice2(int a) {
        String choice1 = mChoices[a][1];
        return choice1;
    }

    public String getChoice3(int a) {
        String choice2 = mChoices[a][2];
        return choice2;
    }

    public String getCorrectAnswer(int a) {
        String answer = mCorrectAnswers[a];
        return answer;
    }

}
