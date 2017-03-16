package com.example.irene.survival_v3.quizActivities;

import java.util.ArrayList;

/**
 * Created by Irene on 08/02/2017.
 */

public class Question {

    public int questionLevel;

    public String mainQuestion;
    public ArrayList<String> answers;
    public ArrayList<String> nextQuestionIds;

    public Question(String mainQuestion, ArrayList<String> answers, ArrayList<String> nextQuestionIds, int questionLevel) {
        this.mainQuestion = mainQuestion;
        this.answers = answers;
        this.nextQuestionIds = nextQuestionIds;
        this.questionLevel = questionLevel;
    }

    public int getNumOptions(){
        return answers.size();
    }

    public Question(){
    }

}
