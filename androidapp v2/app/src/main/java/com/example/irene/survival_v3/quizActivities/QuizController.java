package com.example.irene.survival_v3.quizActivities;


import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


/**
 * Created by Irene on 08/02/2017.
 */

public class QuizController {

    public int MAX_NUM_ANSWERS = 5;
    public int MAX_NUM_QUEST = 10;
    public HashMap<String, Question> questionMap = new HashMap<String, Question>();
    public Question currQuestion;
    //    answerID: -1 = no Answer, -2 = First Question
    private int answerID;
    public int countQuest = 2;

    public QuizController() {
        answerID = -2;
        loadQuestions();
    }

    private void loadQuestions() {
        //TODO: [Patrick] Load questions from json file.
        //TODO: [Patrick] Srt max num of questions as a parameter (not static) taken from json

        ArrayList<String> answers = new ArrayList<String>();
        answers.addAll(Arrays.asList(new String[]{"Tornado", "Hurricane", "Earthquake", "Tsunami/Floods", "Terrorist Attack"}));
        ArrayList<String> ids = new ArrayList<String>();
        ids.addAll(Arrays.asList(new String[]{"2", "2", "2", "2", "2"}));
        Question q = new Question("What happened?", answers, ids, 1);
        questionMap.put("FIRST", q);

        ArrayList<String> answers2 = new ArrayList<String>();
        answers2.addAll(Arrays.asList(new String[]{"Yes (2.2)", "No (3)"}));
        ArrayList<String> ids2 = new ArrayList<String>();
        ids2.addAll(Arrays.asList(new String[]{"2.2", "3"}));
        Question q2 = new Question("Are you injured? 2", answers2, ids2, 1);
        questionMap.put("2", q2);

        ArrayList<String> answers3 = new ArrayList<String>();
        answers3.addAll(Arrays.asList(new String[]{"Yes (2.3)", "No (3)"}));
        ArrayList<String> ids3 = new ArrayList<String>();
        ids3.addAll(Arrays.asList(new String[]{"2.3", "3"}));
        Question q3 = new Question("Quest 2.2", answers3, ids3, 1);
        questionMap.put("2.2", q3);

        ArrayList<String> answers4 = new ArrayList<String>();
        answers4.addAll(Arrays.asList(new String[]{"Yes (last)", "No (last)"}));
        ArrayList<String> ids4 = new ArrayList<String>();
        ids4.addAll(Arrays.asList(new String[]{"LAST", "LAST"}));
        Question q4 = new Question("Do you need urgent help? 2.3", answers4, ids4, 1);
        questionMap.put("2.3", q4);

        ArrayList<String> answers5 = new ArrayList<String>();
        answers5.addAll(Arrays.asList(new String[]{"Yes (2.3)", "No (last)"}));
        ArrayList<String> ids5 = new ArrayList<String>();
        ids5.addAll(Arrays.asList(new String[]{"2.3", "LAST"}));
        Question q5 = new Question("Are you stuck? 3", answers5, ids5, 1);
        questionMap.put("3", q5);

        ArrayList<String> answers6 = new ArrayList<String>();
        answers6.addAll(Arrays.asList(new String[]{"end", "end"}));
        ArrayList<String> ids6 = new ArrayList<String>();
        ids6.addAll(Arrays.asList(new String[]{"LAST", "LAST"}));
        Question q6 = new Question("Are you in danger? LAST", answers6, ids6, 1);
        questionMap.put("LAST", q6);


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

    public boolean isLastQuestion(Question q){
        Question lastQuest = questionMap.get("LAST");
        if (currQuestion == null) {
            Log.e("#QuizController", "Null question");
            return false;
        }
        if(q.equals(lastQuest)){
            Log.e("#QuizController", "LAST question!");
            //MAX_NUM_QUEST = countQuest;
            return true;
        }else{
            //Log.e("#QuizController", "Not LAST!");
            return false;
        }
    }

    public boolean isFirstQuestion(Question q){
        Question lastQuest = questionMap.get("FIRST");
        if (currQuestion == null) {
            Log.e("#QuizController", "Null question!");
            return false;
        }
        if(q.equals(lastQuest)){
            Log.e("#QuizController", "FIRST question!");
            return true;
        }else{
            //Log.e("#QuizController", "Not FIRST!");
            return false;
        }
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
