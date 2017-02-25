package com.example.irene.survival_v3.collectorDemo;


import com.example.irene.survival_v3.R;

import java.util.ArrayList;

import static android.provider.Settings.Secure.getString;


/**
 * Created by Irene on 08/02/2017.
 */

public class QuizController {

    public ArrayList<Question> questionList = new ArrayList<Question>();

    public QuizController(){
        questionList.add(0,getQuestion("1"));
        questionList.add(1,getQuestion("2"));
        questionList.add(2,getQuestion("3"));
    }

    public Question getQuestion(String id){
        Question question = new Question();
        switch(id) {
            case "1":
                question.id = id;
                question.numOpt = 5;
                question.title = R.string.quest1;
                question.options = R.array.quest1_arrays;
                question.type = "basic";
                break;
            case "2":
                question.id = id;
                question.numOpt = 2;
                question.title = R.string.quest2;
                question.options = R.array.quest2_arrays;
                question.type = "basic";
                break;

            case "3":
                question.id = id;
                question.numOpt = 2;
                question.title = R.string.quest3;
                question.options = R.array.quest3_arrays;
                question.type = "basic";
                break;
        }


        return question;
    }
}
