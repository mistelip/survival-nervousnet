package com.example.irene.survival_v3.collectorDemo;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.IntegerRes;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.irene.survival_v3.R;

import java.util.ArrayList;


public class PageFragment extends Fragment {
    TextView titleQuest;
    public QuizController quiz = new QuizController();

    public PageFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_page, container, false);
        titleQuest = (TextView) view.findViewById(R.id.titleQuest_text);
        Bundle bundle = getArguments();
        // Question title
        int id = bundle.getInt("count");
        String title = getString(quiz.questionList.get(id - 1).title);
        titleQuest.setText(title);

        // Question options
        Resources res = getResources();
        String[] opt = res.getStringArray(quiz.questionList.get(id - 1).options);
        for (int i = 0; i < 5; i++) {
            CheckBox box;
            if (i < quiz.questionList.get(id - 1).numOpt) {
                switch (i) {
                    case 0:
                        box = (CheckBox) view.findViewById(R.id.checkBox1);
                        box.setText(opt[0]);
                        box.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                            }

                        });
                        break;
                    case 1:
                        box = (CheckBox) view.findViewById(R.id.checkBox2);
                        box.setText(opt[1]);
                        break;
                    case 2:
                        box = (CheckBox) view.findViewById(R.id.checkBox3);
                        box.setText(opt[2]);
                        break;
                    case 3:
                        box = (CheckBox) view.findViewById(R.id.checkBox4);
                        box.setText(opt[3]);
                        break;
                    case 4:
                        box = (CheckBox) view.findViewById(R.id.checkBox5);
                        box.setText(opt[4]);
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
