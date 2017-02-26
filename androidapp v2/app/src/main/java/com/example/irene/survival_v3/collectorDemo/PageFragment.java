package com.example.irene.survival_v3.collectorDemo;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.example.irene.survival_v3.R;

import java.util.ArrayList;


public class PageFragment extends Fragment {
    TextView titleQuest;
    private int currAnswer;
    public QuizController quizController;
    private CustomViewPager viewPager;

    public PageFragment() {

    }

    public void setQuizController(QuizController qc) {

        quizController = qc;
    }
    public void setViewPager(CustomViewPager vp) {
        viewPager = vp;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_page, container, false);
        titleQuest = (TextView) view.findViewById(R.id.titleQuest_text);
        viewPager.setPagingEnabled(false);
        //Bundle bundle = getArguments();

        // Question title
        final Question currQuestion = quizController.getNextQuestion();
        titleQuest.setText(currQuestion.mainQuestion);

        if (currQuestion.mainQuestion == null) {
            return view;
        }

        // Question options
        //Resources res = getResources();
//        String[] opt = res.getStringArray(quizController.questionMap.get("FIRST").answers);
        ArrayList<String> opt = currQuestion.answers;
        final int numAns = opt.size();
        final ArrayList<CheckBox> answers = new ArrayList<CheckBox>();


        for (int i = 0; i < quizController.MAX_NUM_ANSWERS; i++) {

            if (i < numAns) {
                switch (i) {
                    case 0:
                        CheckBox box1 = (CheckBox) view.findViewById(R.id.checkBox1);
                        box1.setText(opt.get(i));
                        answers.add(box1);
                        break;
                    case 1:
                        CheckBox box2 = (CheckBox) view.findViewById(R.id.checkBox2);
                        box2.setText(opt.get(i));
                        answers.add(box2);
                        break;
                    case 2:
                        CheckBox box3 = (CheckBox) view.findViewById(R.id.checkBox3);
                        box3.setText(opt.get(i));
                        answers.add(box3);
                        break;
                    case 3:
                        CheckBox box4 = (CheckBox) view.findViewById(R.id.checkBox4);
                        box4.setText(opt.get(i));
                        answers.add(box4);
                        break;
                    case 4:
                        CheckBox box5 = (CheckBox) view.findViewById(R.id.checkBox5);
                        box5.setText(opt.get(i));
                        answers.add(box5);
                        break;
                }
            } else {
                switch (i) {
                    case 0:
                        CheckBox box1 = (CheckBox) view.findViewById(R.id.checkBox1);
                        box1.setVisibility(CheckBox.INVISIBLE);
                        break;
                    case 1:
                        CheckBox box2 = (CheckBox) view.findViewById(R.id.checkBox2);
                        box2.setVisibility(CheckBox.INVISIBLE);
                        break;
                    case 2:
                        CheckBox box3 = (CheckBox) view.findViewById(R.id.checkBox3);
                        box3.setVisibility(CheckBox.INVISIBLE);
                        break;
                    case 3:
                        CheckBox box4 = (CheckBox) view.findViewById(R.id.checkBox4);
                        box4.setVisibility(CheckBox.INVISIBLE);
                        break;
                    case 4:
                        CheckBox box5 = (CheckBox) view.findViewById(R.id.checkBox5);
                        box5.setVisibility(CheckBox.INVISIBLE);
                        break;
                }
            }

        }

        for (int i = 0; i < numAns; i++) {
            final int id = i;
            CheckBox box = answers.get(i);
            box.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.d("#PageFragment","Set CurrAnswer "+id);
                    currAnswer = id;
                    quizController.setCurrAnswer(currAnswer);

                    for (int i = 0; i < numAns; i++) {
                        if(i != id && answers.get(i).isChecked()){
                            answers.get(i).toggle();
                        }
                    }
                    viewPager.setPagingEnabled(true);
                }

            });
        }

        return view;
    }


}
