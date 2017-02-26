package com.example.irene.survival_v3.collectorDemo;


import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


/**
 * Created by Irene on 08/02/2017.
 */

public class QuizController {

    public int MAX_NUM_ANSWERS = 5;
    public HashMap<String, Question> questionMap = new HashMap<String, Question>();
    public Question currQuestion;
    //    answerID: -1 = no Answer, -2 = First Question
    private int answerID;

    public QuizController() {
        answerID = -2;
        loadQuestions();
    }

    private void loadQuestions() {
        //TODO: [Patrick] Load questions from json file.

        ArrayList<String> answers = new ArrayList<String>();
        answers.addAll(Arrays.asList(new String[]{"2", "3", "4"}));
        ArrayList<String> ids = new ArrayList<String>();
        ids.addAll(Arrays.asList(new String[]{"2", "3", "4"}));
        Question q = new Question("Quest 1?", answers, ids, 1);
        questionMap.put("FIRST", q);

        ArrayList<String> answers2 = new ArrayList<String>();
        answers2.addAll(Arrays.asList(new String[]{"1", "4"}));
        ArrayList<String> ids2 = new ArrayList<String>();
        ids2.addAll(Arrays.asList(new String[]{"FIRST", "4"}));
        Question q2 = new Question("Quest 2", answers2, ids2, 1);
        questionMap.put("2", q2);

        ArrayList<String> answers3 = new ArrayList<String>();
        answers3.addAll(Arrays.asList(new String[]{"2", "4"}));
        ArrayList<String> ids3 = new ArrayList<String>();
        ids3.addAll(Arrays.asList(new String[]{"2", "4"}));
        Question q3 = new Question("Quest 3", answers3, ids3, 1);
        questionMap.put("3", q3);

        ArrayList<String> answers4 = new ArrayList<String>();
        answers4.addAll(Arrays.asList(new String[]{"end", "end"}));
        ArrayList<String> ids4 = new ArrayList<String>();
        ids4.addAll(Arrays.asList(new String[]{"4", "4"}));
        Question q4 = new Question("Quest 4", answers4, ids4, 1);
        questionMap.put("4", q4);


    }

    public void setCurrAnswer(int i) {
        answerID = i;
    }

    public int getCurrAnswer() {
        return answerID;
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
