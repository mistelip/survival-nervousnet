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
    public QuizController quizController;

    public PageFragment() {

    }

    public void setQuizController(QuizController qc) {
        quizController = qc;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_page, container, false);
        titleQuest = (TextView) view.findViewById(R.id.titleQuest_text);
        Bundle bundle = getArguments();

        // Question title
        Question currQuestion = quizController.getNextQuestion();
        titleQuest.setText(currQuestion.mainQuestion);

        if (currQuestion.mainQuestion == null) {
            return view;
        }
        // Question options
        Resources res = getResources();
//        String[] opt = res.getStringArray(quizController.questionMap.get("FIRST").answers);
        ArrayList<String> opt = currQuestion.answers;
        for (int i = 0; i < 5; i++) {
            CheckBox box;
            if (i < opt.size()) {
                switch (i) {
                    case 0:
                        box = (CheckBox) view.findViewById(R.id.checkBox1);
                        box.setText(opt.get(i));
                        box.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Log.d("#PageFragment","Set CurrAnswer 0");
                                quizController.setCurrAnswer(0);
                            }

                        });
                        break;
                    case 1:
                        box = (CheckBox) view.findViewById(R.id.checkBox2);
                        box.setText(opt.get(i));
                        box.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Log.d("#PageFragment","Set CurrAnswer 1");
                                quizController.setCurrAnswer(1);
                            }

                        });
                        break;
                    case 2:
                        box = (CheckBox) view.findViewById(R.id.checkBox3);
                        box.setText(opt.get(i));
                        break;
                    case 3:
                        box = (CheckBox) view.findViewById(R.id.checkBox4);
                        box.setText(opt.get(i));
                        break;
                    case 4:
                        box = (CheckBox) view.findViewById(R.id.checkBox5);
                        box.setText(opt.get(i));
                        break;
                }
            } else {
                switch (i) {
                    case 0:
                        box = (CheckBox) view.findViewById(R.id.checkBox1);
                        box.setVisibility(CheckBox.INVISIBLE);
                        break;
                    case 1:
                        box = (CheckBox) view.findViewById(R.id.checkBox2);
                        box.setVisibility(CheckBox.INVISIBLE);
                        break;
                    case 2:
                        box = (CheckBox) view.findViewById(R.id.checkBox3);
                        box.setVisibility(CheckBox.INVISIBLE);
                        break;
                    case 3:
                        box = (CheckBox) view.findViewById(R.id.checkBox4);
                        box.setVisibility(CheckBox.INVISIBLE);
                        break;
                    case 4:
                        box = (CheckBox) view.findViewById(R.id.checkBox5);
                        box.setVisibility(CheckBox.INVISIBLE);
                        break;
                }
            }

        }
        return view;
    }


}
