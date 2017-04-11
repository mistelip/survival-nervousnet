package com.example.irene.survival_v3.quizActivities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.irene.survival_v3.R;

import java.util.ArrayList;


public class QuizPageFragment extends Fragment implements QuizFragmentInterface {
    private int currAnswer = -1;
    public QuizController quizController;
    private QuizViewPager viewPager;
    private View myView;
    private Question myQuestion;
    private Question myQuestionBefore;
    private boolean newFragment = true;
    private boolean unblocked =  false;

    public QuizPageFragment() {}

    public void setQuizController(QuizController qc) {
        quizController = qc;
    }


    public void setViewPager(QuizViewPager vp) {
        viewPager = vp;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View myView = inflater.inflate(R.layout.fragment_page, container, false);
        this.myView = myView;

        return myView;
    }

    @Override
    public void fragmentBecameVisible() {
        //Log.d("#PafeFragment", "Fragment visible");

        // Set Last question or a new one
        if(newFragment) {
            Log.d("#PafeFragment", "NEW fragment");
            myQuestionBefore = quizController.getCurrQuestion();
            myQuestion = quizController.getNextQuestion();
            newFragment = false;
        }else if(viewPager.lastSwipeLeft){
            Log.d("#PafeFragment", "LEFT fragment");
            myQuestion =  myQuestionBefore;
        }

        //myQuestion =  quizController.getNextQuestion();
        if(unblocked){
            viewPager.setAllowedSwipeDirection(SwipeDirection.all);
            //Log.d("#QuizPageFragment","Allow swipe ALL");
        }else{
            viewPager.setAllowedSwipeDirection(SwipeDirection.left);
            //Log.d("#QuizPageFragment","Allow swipe LEFT");
        }

        // Last question can't swipe forward anymore
        if(quizController.isLastQuestion(myQuestion)){
            viewPager.setAllowedSwipeDirection(SwipeDirection.left);
        }

        // Question title
        TextView titleQuest = (TextView) myView.findViewById(R.id.titleQuest_text);
        titleQuest.setText(myQuestion.mainQuestion);


        // Question options
        //Resources res = getResources();
//        String[] opt = res.getStringArray(quizController.questionMap.get("FIRST").answers);
        ArrayList<String> opt = myQuestion.answers;
        final int numAns = opt.size();
        final ArrayList<CheckBox> answers = new ArrayList<CheckBox>();

        for (int i = 0; i < quizController.MAX_NUM_ANSWERS; i++) {

            if (i < numAns) {
                switch (i) {
                    case 0:
                        CheckBox box1 = (CheckBox) myView.findViewById(R.id.checkBox1);
                        box1.setText(opt.get(i));
                        answers.add(box1);
                        break;
                    case 1:
                        CheckBox box2 = (CheckBox) myView.findViewById(R.id.checkBox2);
                        box2.setText(opt.get(i));
                        answers.add(box2);
                        break;
                    case 2:
                        CheckBox box3 = (CheckBox) myView.findViewById(R.id.checkBox3);
                        box3.setText(opt.get(i));
                        answers.add(box3);
                        break;
                    case 3:
                        CheckBox box4 = (CheckBox) myView.findViewById(R.id.checkBox4);
                        box4.setText(opt.get(i));
                        answers.add(box4);
                        break;
                    case 4:
                        CheckBox box5 = (CheckBox) myView.findViewById(R.id.checkBox5);
                        box5.setText(opt.get(i));
                        answers.add(box5);
                        break;
                }
            } else {
                switch (i) {
                    case 0:
                        CheckBox box1 = (CheckBox) myView.findViewById(R.id.checkBox1);
                        box1.setVisibility(CheckBox.INVISIBLE);
                        break;
                    case 1:
                        CheckBox box2 = (CheckBox) myView.findViewById(R.id.checkBox2);
                        box2.setVisibility(CheckBox.INVISIBLE);
                        break;
                    case 2:
                        CheckBox box3 = (CheckBox) myView.findViewById(R.id.checkBox3);
                        box3.setVisibility(CheckBox.INVISIBLE);
                        break;
                    case 3:
                        CheckBox box4 = (CheckBox) myView.findViewById(R.id.checkBox4);
                        box4.setVisibility(CheckBox.INVISIBLE);
                        break;
                    case 4:
                        CheckBox box5 = (CheckBox) myView.findViewById(R.id.checkBox5);
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
                    Log.d("#QuizPageFragment","Set CurrAnswer "+id);
                    currAnswer = id;
                    quizController.setCurrAnswer(currAnswer);

                    // Uncheck all the other answers
                    int unchecked = 0;
                    for (int i = 0; i < numAns; i++) {
                        if(i != id && answers.get(i).isChecked()){
                            answers.get(i).toggle();
                        }else if(!answers.get(i).isChecked()){
                            unchecked++;
                        }
                    }

                    // only allow to swipe if is not the last and there is something checked
                    if(!quizController.isLastQuestion(myQuestion) && unchecked != numAns){
                        viewPager.setAllowedSwipeDirection(SwipeDirection.all);
                        Log.d("#QuizPageFragment","Swipe ALL");
                        unblocked = true;
                    }else{
                        viewPager.setAllowedSwipeDirection(SwipeDirection.left);
                        Log.d("#QuizPageFragment","Swipe LEFT");
                        unblocked = false;
                    }

                    //viewPager.setPagingEnabled(true);
                }

            });

        }



    }


}
