package com.example.irene.survival_v3.collectorDemo;


import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


/**
 * Created by Irene on 08/02/2017.
 */

public class QuizController {

    public HashMap<String, Question> questionMap = new HashMap<String, Question>();
    private Question currQuestion;
    //    answerID: -1 = no Answer, -2 = First Question
    private int answerID;

    public QuizController() {
        answerID = -2;
        loadQuestions();
    }

    private void loadQuestions() {
        //TODO: [Patrick] Load questions from json file.

        ArrayList<String> answers = new ArrayList<String>();
        answers.addAll(Arrays.asList(new String[]{"Ass", "Meth", "crack"}));
        ArrayList<String> ids = new ArrayList<String>();
        ids.addAll(Arrays.asList(new String[]{"mlemle1", "mlemle1", "mlemle2"}));
        Question q = new Question("What happened?", answers, ids, 1);
        questionMap.put("FIRST", q);

        ArrayList<String> answers2 = new ArrayList<String>();
        answers2.addAll(Arrays.asList(new String[]{"Yes", "No"}));
        ArrayList<String> ids2 = new ArrayList<String>();
        ids2.addAll(Arrays.asList(new String[]{"mlemle1", "mlemle2"}));
        Question q2 = new Question("Are you injured", answers2, ids2, 1);
        questionMap.put("mlemle1", q2);

        ArrayList<String> answers3 = new ArrayList<String>();
        answers3.addAll(Arrays.asList(new String[]{"Yes", "No"}));
        ArrayList<String> ids3 = new ArrayList<String>();
        ids3.addAll(Arrays.asList(new String[]{"mlemle1", "mlemle2"}));
        Question q3 = new Question("Are you Stuck", answers3, ids3, 1);
        questionMap.put("mlemle2", q3);


    }

    public void setCurrAnswer(int i) {
        answerID = i;
    }

    public Question getNextQuestion() {
        if (answerID == -2) {
            Log.e("#QuizController", "Loading First Question");
            return getFirstQuestion();
        }
        if (answerID == -1) {
            Log.e("#QuizController", "No Answer Selected");
            return currQuestion;
        }

        if (currQuestion == null) {
            Log.e("#QuizController", "No Current Question");
            return new Question();
        }

        String nextQuestionId = currQuestion.nextQuestionIds.get(answerID);
        currQuestion = questionMap.get(nextQuestionId);
        answerID = -1;
        return currQuestion;
    }

    private Question getFirstQuestion() {
        currQuestion = questionMap.get("FIRST");
        if (currQuestion == null) {
            Log.e("#QuizController", "FIRST Question not set");
        }
        answerID = -1;
        return currQuestion;
    }
}
