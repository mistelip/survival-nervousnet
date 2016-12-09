package com.example.cpcrasher.survival.mainActivity;

import android.app.Application;

/**
 * Created by Irene on 29/11/2016.
 */

public class MyQuiz extends Application {
    public boolean basicNeedsDone = false;
    public boolean suppNeedsDone = false;

    // GET
    public boolean getQuizDone(String quiz){
        switch(quiz){
            case "basicNeeds":
                return basicNeedsDone;
            case "suppNeeds":
                return suppNeedsDone;
        }
        return false;
    }

    //SET
    public void setQuizDone(String quiz){
        switch(quiz){
            case "basicNeeds":
                basicNeedsDone = true;
                break;
            case "suppNeeds":
                suppNeedsDone = true;
                break;
        }
    }
}
