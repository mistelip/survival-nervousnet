package com.example.irene.survival_v3.collectorDemo;

/**
 * Created by Irene on 08/02/2017.
 */

public class Question {
    // Specify total number of questiosn in the
    public static int NUM_QUESTIONS = 5;

    public String id;
    public String type;
    public int title;
    public int numOpt;
    public int options;

    public Question(String id, String type, int title, int numOpt) {
        this.id = id;
        this.type = type;
        this.title = title;
    }
    public Question(){
    }

}
