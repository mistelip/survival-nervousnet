package com.example.cpcrasher.survival.mainActivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.cpcrasher.survival.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //boolean basicNeedsDone = ((MyQuiz) this.getApplication()).getQuizDone("basicNeeds");

        //*
        // Basic needs
        Button basicNeeds_butt = (Button) findViewById(R.id.basicNeeds_butt);
        basicNeeds_butt.setEnabled(false);
        basicNeeds_butt.setOnClickListener(new View.OnClickListener() {
        //earthquake_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, BasicNeedsActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });
        /*
        if(((MyQuiz)this.getApplication()).getQuizDone("basicNeeds")){
            basicNeeds_butt.setEnabled(false);
        }
        //*/
        // TSupporting needs
        final Button suppNeeds_butt = (Button) findViewById(R.id.suppNeeds_butt);
        suppNeeds_butt.setOnClickListener(new View.OnClickListener(){
        //tsunami_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SuppNeedsActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);

            }
        });


        // Surroundings state
        Button surroundings_butt = (Button) findViewById(R.id.surroundings_butt);
        surroundings_butt.setOnClickListener(new View.OnClickListener() {
        //tsunami_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SurroundingsActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });

        // Extra information
        Button extra_butt = (Button) findViewById(R.id.extra_butt);
        extra_butt.setOnClickListener(new View.OnClickListener() {
            //tsunami_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ExtrasActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });

    }




}
